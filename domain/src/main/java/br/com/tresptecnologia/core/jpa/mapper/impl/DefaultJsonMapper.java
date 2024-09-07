package br.com.tresptecnologia.core.jpa.mapper.impl;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapperConfig;
import br.com.tresptecnologia.core.jpa.mapper.Row;
import br.com.tresptecnologia.core.jpa.mapper.exception.JsonMapperException;
import br.com.tresptecnologia.core.jpa.mapper.impl.model.ObjectIdentifier;
import br.com.tresptecnologia.core.jpa.mapper.impl.model.ObjectRoot;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class DefaultJsonMapper implements JsonMapper {

    private static final JsonMapperConfig JSON_MAPPER_CONFIG = new JsonMapperConfig("*", "[]");

    private final ObjectMapper objectMapper;

    public DefaultJsonMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> List<T> toListModel(List<Row> rows, Class<T> clazz) throws JsonMapperException {
        try {
            // Utiliza o proprio jackson para criar o JavaType da lista generica
            final JavaType type = objectMapper.getTypeFactory().
                    constructCollectionType(List.class, clazz);

            // Mapea o resultado para um array
            final ArrayNode arrayNode = toJsonArray(rows);

            // Realiza o mapeamento dos dados em json para o modelo de dados informado
            return objectMapper.readerFor(type).readValue(arrayNode);
        } catch (Exception ex) {
            log.debug("Falha ao realizar o mapeamento para a lista de modelos", ex);
            throw new JsonMapperException("Falha ao realizar o mapeamento para a lista de modelos", ex);
        }
    }

    @Override
    public <T> T toModel(Row row, Class<T> clazz) throws JsonMapperException {
        try {
            // Mapea o resultado para um objectNode
            final ObjectNode objectNode = toJson(row);

            // Realiza o mapeamento do json para o modelo de dados informado
            return objectMapper.treeToValue(objectNode, clazz);
        } catch (Exception ex) {
            log.debug("Falha ao realizar o mapeamento para o modelo", ex);
            throw new JsonMapperException("Falha ao realizar o mapeamento para o modelo", ex);
        }
    }

    /**
     * @param rows - Lista de registros
     * @return ArrayNode contendo a lista de dados mapeados para um Json
     * @throws JsonMapperException - Quando houver uma exception
     */
    @Override
    public ArrayNode toJsonArray(List<Row> rows) throws JsonMapperException {

        if (Objects.isNull(rows) || rows.isEmpty()) {
            return objectMapper.createArrayNode();
        }

        // Utilizado para cachear o armazenado dos objetos já mepeados. Tem como objetivo disponibilizar
        // uma rapida consulta de um objeto atraves do seu ID
        final Map<Object, ObjectNode> objectNodeCache = new LinkedHashMap<>();

        // Utilizado para realizar o mapeamento das propriedades que são identificadores
        // e o encadeamento de propriedades atraves da sua hierarquia
        final ObjectRoot objectRoot = getObjectStructure(JSON_MAPPER_CONFIG, rows.get(0).getKeys());

        for (final Row row : rows) {
            mapRow(objectNodeCache, objectRoot, row);
        }

        //Cria um array e insere todos os dados mapeados que estão armazenados no cache
        final ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.addAll(objectNodeCache.values());
        return arrayNode;
    }

    /**
     * @param toJsonPage - Lista de registros
     * @return ArrayNode contendo a lista de dados mapeados para um Json
     * @throws JsonMapperException - Quando houver uma exception
     */
    @Override
    public ObjectNode toJsonPage(Page<Row> rowPage) throws JsonMapperException {

        if (Objects.isNull(rowPage) || rowPage.isEmpty()) {
            return objectMapper.valueToTree(rowPage);
        }

        // Utilizado para cachear o armazenado dos objetos já mepeados. Tem como objetivo disponibilizar
        // uma rapida consulta de um objeto atraves do seu ID
        final Map<Object, ObjectNode> objectNodeCache = new LinkedHashMap<>();

        // Utilizado para realizar o mapeamento das propriedades que são identificadores
        // e o encadeamento de propriedades atraves da sua hierarquia
        final List<Row> rows = rowPage.getContent();
        final ObjectRoot objectRoot = getObjectStructure(JSON_MAPPER_CONFIG, rows.get(0).getKeys());

        for (final Row row : rows) {
            mapRow(objectNodeCache, objectRoot, row);
        }

        final Page<ObjectNode> newPage = new PageImpl<>(objectNodeCache.values().stream().toList(),
                rowPage.getPageable(), rowPage.getTotalElements());

        return objectMapper.valueToTree(newPage);
    }

    @Override
    public ObjectNode toJson(Row row) throws JsonMapperException {

        // Utilizado para cachear o armazenado dos objetos já mepeados. Tem como objetivo disponibilizar
        // uma rapida consulta de um objeto atraves do seu ID
        final Map<Object, ObjectNode> objectNodeCache = new HashMap<>();

        // Utilizado para realizar o mapeamento das propriedades que são identificadores
        // e o encadeamento de propriedades atraves da sua hierarquia
        ObjectRoot objectRoot = getObjectStructure(JSON_MAPPER_CONFIG, row.getKeys());

        return mapRow(objectNodeCache, objectRoot, row);
    }

    public ObjectNode mapRow(final Map<Object, ObjectNode> hashNodes,
                             final ObjectRoot objectRoot,
                             final Row row) {

        // Realiza a limpeza de qualquer dado cacheado na estrutura
        objectRoot.clear();

        final ObjectIdentifier rootObjectId = objectRoot.getRootObjectId();

        final Object identifierPropertyValue = row.get(rootObjectId.getField());
        final ObjectNode objectNodeIdentifier = getJsonNodeOrCreate(hashNodes, identifierPropertyValue);

        // Adiciona ao idenficador o valor do ID e o objectNode
        rootObjectId.setValueId(identifierPropertyValue);
        rootObjectId.setMyObject(objectNodeIdentifier);

        // Preenche as propriedades e valores
        fillPropertiesAndValues(rootObjectId, rootObjectId.getMyObject(), row);


        // Para cada propriedade idenficadora, é realizado o mapeamento do json e preenchido as propriedades e seus
        // respectivos valores, sempre mantendo a hierarquia
        for (final ObjectIdentifier innerIdentifier : objectRoot.getObjectIdentifiers()) {
            final Object innerIdentifierPropertyValue = row.get(innerIdentifier.getField());
            innerIdentifier.setValueId(innerIdentifierPropertyValue);

            final ObjectNode innerObjectNodeIdentifier = mapObjectId(innerIdentifier, innerIdentifierPropertyValue);

            fillPropertiesAndValues(innerIdentifier, innerObjectNodeIdentifier, row);
        }

        return objectNodeIdentifier;
    }

    /**
     * Mapea uma linha para um Json
     *
     * @param objectIdentifier
     * @param valueId
     * @return
     */
    public ObjectNode mapObjectId(ObjectIdentifier objectIdentifier, Object valueId) {

        // Verifica se o identificador é um array
        if (objectIdentifier.isArray()) {

            final ArrayNode parentArray = (ArrayNode) objectIdentifier.getParentId()
                    .getMyObject().get(objectIdentifier.getPrefixClean());

            if (parentArray == null) {
                // Instancia um array node para o pai
                final ArrayNode array = objectMapper.createArrayNode();

                // Adiciona o array no pai
                objectIdentifier.getParentId().getMyObject()
                        .set(objectIdentifier.getPrefixClean(), array);

                // Cria um novo objeto e adiciona as informações e coloca no pai
                final ObjectNode objectNodeIdentifier = createIdentifierJsonNode(objectIdentifier, valueId);
                array.add(objectNodeIdentifier);

                return objectNodeIdentifier;
            } else {
                // Consulta se já existe o objeto no array para preencher as propriedades faltantes
                for (final JsonNode jsonNode : parentArray) {
                    final JsonNode propertyJsonNodeId = jsonNode.get(objectIdentifier.getFieldClean());

                    // Valida se o JsonNode do identificador é igual ao valor atual do registro
                    if (propertyJsonNodeId != null && propertyJsonNodeId
                            .asText().equals(String.valueOf(valueId))) {
                        return (ObjectNode) jsonNode;
                    }
                }

                // Caso não tenha, é adicionado objeto no array do seu pai
                final ObjectNode objectNodeIdentifier = createIdentifierJsonNode(objectIdentifier, valueId);
                parentArray.add(objectNodeIdentifier);

                return objectNodeIdentifier;
            }
        } else {
            final ObjectNode objectNode = (ObjectNode) objectIdentifier.getParentId().getMyObject()
                    .get(objectIdentifier.getPrefixClean());

            // Se já existir um objetNode
            if (objectNode != null) {
                return objectNode;
            }

            // Senão existir, é criado e configurado os valores de identificação
            final ObjectNode objectNodeIdentifier = createIdentifierJsonNode(objectIdentifier, valueId);
            objectIdentifier.getParentId().getMyObject().set(objectIdentifier.getPrefixClean(), objectNodeIdentifier);

            return objectNodeIdentifier;
        }
    }

    private ObjectNode createIdentifierJsonNode(ObjectIdentifier objectIdentifier, Object valueId) {
        final ObjectNode objectNode = objectMapper.createObjectNode();

        objectIdentifier.setMyObject(objectNode);
        objectIdentifier.setValueId(valueId);

        return objectNode;
    }

    /**
     * Preenche no objeto json atual as propriedades e seus valores
     *
     * @param objectIdentifier
     * @param objectNode
     * @param row
     */
    public void fillPropertiesAndValues(ObjectIdentifier objectIdentifier, ObjectNode objectNode, Row row) {
        for (final String property : objectIdentifier.getProperties()) {
            final String normalizedProperty = objectIdentifier.normalize(property);
            final Object propertyValue = row.get(objectIdentifier.getProperty(property));

            if (Objects.isNull(propertyValue)) {
                objectNode.putNull(normalizedProperty);
            } else {
                objectNode.set(normalizedProperty, objectMapper.valueToTree(propertyValue));
            }
        }
    }

    /**
     * Responsavel por mapear a estrutura inicial do objeto, utilizando
     * encadeamento.
     *
     * @param properties Propriedades
     * @return
     */
    private ObjectRoot getObjectStructure(final JsonMapperConfig config, Collection<String> properties) {

        final ObjectRoot objectRoot = new ObjectRoot();

        final List<String> identifiers = filterIdentifiers(config, properties);

        for (String identifier : identifiers) {

            // Verifica se o ID é do objeto root
            final boolean isRoot = !identifier.contains(".");

            final ObjectIdentifier objectIdentifier = new ObjectIdentifier();
            objectIdentifier.setField(identifier);

            if (isRoot) {
                // Filtra todas as propriedades do Root
                final List<String> allProperties = properties.stream().filter(x -> !x.contains(".")).toList();
                objectIdentifier.setProperties(allProperties);

                // Isola a propriedade de identificação do root na propriedade rootObjectId
                objectRoot.setRootObjectId(objectIdentifier);

            } else {

                // Consulta o prefixo da propriedade
                final String prefix = identifier.substring(0, identifier.lastIndexOf("."));
                if (prefix.contains(".")) {

                    // Consulta qual o prefixo do pai
                    final String prefixParent = prefix.substring(0, prefix.lastIndexOf("."));
                    objectIdentifier.setPrefixParent(prefixParent);
                }

                // Seta o prefixo do objeto identificador
                objectIdentifier.setPrefix(prefix);

                // Caso termina com o token de array, é informado que aquela propriedade é um array
                objectIdentifier.setArray(prefix.endsWith(config.tokenArray()));

                // Filtra todas as propriedades do prefixo
                final List<String> allProperties = properties.stream()
                        .filter(x -> x.startsWith(prefix + "."))
                        .filter(x -> !x.replace(prefix + ".", "").contains("."))
                        .map(x -> x.replace(prefix + ".", ""))
                        .toList();
                objectIdentifier.setProperties(allProperties);

                // Adiciona na lista de idenficadores do root
                objectRoot.getObjectIdentifiers().add(objectIdentifier);
            }
        }

        configureHierarchyPath(objectRoot);

        return objectRoot;
    }

    /**
     * Realiza a contagem da quantidade de pontos de uma string
     *
     * @param str
     * @return
     */
    private static int countDots(String str) {
        return str.length() - str.replace(".", "").length();
    }

    /**
     * Filtra as propriedades que são identificadores
     *
     * @param config     Configuração do mapeamento
     * @param properties Propriedades/Colunas
     * @return
     */
    private List<String> filterIdentifiers(final JsonMapperConfig config, final Collection<String> properties) {
        return properties.stream().filter(x -> x.endsWith(config.tokenId()))
                .sorted(Comparator.comparingInt(DefaultJsonMapper::countDots)).toList();
    }

    /**
     * Configura a hierarquia das propriedades de identificação.
     * Se uma propriedade de identificação é filha de outra, essa função é responsavel por fazer a vinculação
     * desta hierarquia atraves do setParentId.
     *
     * @param objectRoot Estrutura root do objeto
     */
    private void configureHierarchyPath(ObjectRoot objectRoot) {
        objectRoot.getObjectIdentifiers().forEach(x -> x.setParentId(objectRoot.getObjectIdentifiers().stream()
                .filter(y -> y.getPrefix()
                        .equals(x.getPrefixParent())).findFirst()
                .orElse(objectRoot.getRootObjectId())));
    }

    /**
     * Consulta o objeto inicial já criado e que está cacheado
     *
     * @param objectNodeCache
     * @param key
     * @return
     */
    private ObjectNode getJsonNodeOrCreate(Map<Object, ObjectNode> objectNodeCache, final Object key) {
        if (objectNodeCache.containsKey(key)) {
            return objectNodeCache.get(key);
        } else {
            final ObjectNode objectNode = objectMapper.createObjectNode();
            objectNodeCache.put(key, objectNode);
            return objectNode;
        }
    }
}
