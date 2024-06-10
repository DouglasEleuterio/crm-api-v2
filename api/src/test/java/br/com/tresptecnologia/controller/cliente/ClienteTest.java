package br.com.tresptecnologia.controller.cliente;

import br.com.tresptecnologia.core.controller.model.ErrorResponse;
import br.com.tresptecnologia.entity.cliente.Cidade;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.entity.cliente.Endereco;
import br.com.tresptecnologia.entity.cliente.Estado;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.cliente.ClienteResponse;
import br.com.tresptecnologia.model.entity.BaseEntityActiveRequest;
import br.com.tresptecnologia.model.exemplo.ExemploResponse;
import br.com.tresptecnologia.repository.cidade.CidadeRepository;
import br.com.tresptecnologia.repository.cliente.ClienteRepository;
import br.com.tresptecnologia.repository.estado.EstadoRepository;
import br.com.tresptecnologia.support.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@Rollback
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteTest extends BaseTest {

    private final String CLIENTE_API = "/cliente";

    @Mock
    private Cliente cliente;

    @SpyBean
    private ClienteRepository clienteRepository;

    @SpyBean
    private EstadoRepository estadoRepository;

    @SpyBean
    private CidadeRepository cidadeRepository;

    @BeforeEach
    public void setUp() {
        Mockito.reset(clienteRepository);
    }

    @Test
    @Rollback
    void testarConsultar_IdInvalido_RetornarError() throws Exception {
        final MockHttpServletRequestBuilder requestBuilder = get(CLIENTE_API + "/999").with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id 999 não encontrado.", response.getMessage());

    }

    @Test
    @Rollback
    void testarConsultar_IdValido_RetornarOk() throws Exception {
        final var id = 2L;
        when(cliente.getId()).thenReturn(id);
        when(cliente.getNome()).thenReturn("Nome Teste");
        when(cliente.getTelefone()).thenReturn("62999999999");
        when(cliente.getEmail()).thenReturn("teste@email.com");
        when(cliente.getCpf()).thenReturn("40049617001");
        when(cliente.getDataNascimento()).thenReturn(LocalDate.now());

        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        final MockHttpServletRequestBuilder requestBuilder = get(CLIENTE_API + "/" + id).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final ClienteResponse clienteResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ClienteResponse.class);

        Assertions.assertEquals(cliente.getId(), clienteResponse.getId());
        Assertions.assertEquals(cliente.getNome(), clienteResponse.getNome());
        Assertions.assertEquals(cliente.getCpf(), clienteResponse.getCpf());
        Assertions.assertEquals(cliente.getEmail(), clienteResponse.getEmail());
        Assertions.assertEquals(cliente.getTelefone(), clienteResponse.getTelefone());
        Assertions.assertEquals(cliente.getDataNascimento(), clienteResponse.getDataNascimento());
    }

    @Test
    @Rollback
    void testarAdicionar_DadosVazios_RetornarError() throws Exception {
        assertMessages(errorsValidations(CLIENTE_API, 6, new ClienteRequest()),
                "O campo Nome é obrigatório.",
                "O campo Telefone é obrigatório.",
                "O campo CPF é obrigatório.",
                "O campo Email é obrigatório.",
                "O campo Data de Nascimento é obrigatório.",
                "O campo Endereï¿½o é obrigatório."
        );
    }

    @Test
    @Rollback
    void testarAdicionar_DadosValidos_RetornarOk() throws Exception {
        var estado = estadoRepository.saveAndFlush(Estado.builder()
                .nome("Goias")
                .codigoIBGE("53")
                .uf("GO")
                .build());
        var cidade = cidadeRepository.saveAndFlush(Cidade.builder()
                .nome("São Patricio")
                .codigoIBGE("53100396")
                .estado(estado)
                .build());


        var endereco = Endereco.builder()
                .logradouro("Av B")
                .numero("S/N")
                .complemento("Qd A")
                .bairro("Centro")
                .cidade(cidade)
                .cep("76343000")
                .build();

        final ClienteRequest exemploRequest = ClienteRequest.builder()
                .nome("Exemplo Nome")
                .telefone("62999999999")
                .cpf("40049617001")
                .email("teste@email.com")
                .dataNascimento(LocalDate.now())
                .endereco(endereco)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = post(CLIENTE_API).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isCreated());

        final ClienteResponse exemploResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ClienteResponse.class);

        Assertions.assertNotNull(exemploResponse.getId());
        Assertions.assertEquals(exemploRequest.getNome(), exemploResponse.getNome());
    }

    @Test
    @Rollback
    void testarAtualizar_DadosVazios_RetornarError() throws Exception {
        ClienteRequest exemploRequest = ClienteRequest.builder().build();

        final MockHttpServletRequestBuilder requestBuilder = put(CLIENTE_API + "/1").content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        assertMessages(result, "O campo Nome é obrigatório.");

    }

    @Test
    @Rollback
    void testarAtualizar_IdInvalido_RetornarError() throws Exception {
        final var id = 2L;
        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        var estado = estadoRepository.saveAndFlush(Estado.builder()
                .nome("Goias")
                .codigoIBGE("53")
                .uf("GO")
                .build());
        var cidade = cidadeRepository.saveAndFlush(Cidade.builder()
                .nome("São Patricio")
                .codigoIBGE("53100396")
                .estado(estado)
                .build());


        var endereco = Endereco.builder()
                .logradouro("Av B")
                .numero("S/N")
                .complemento("Qd A")
                .bairro("Centro")
                .cidade(cidade)
                .cep("76343000")
                .build();

        final ClienteRequest exemploRequest = ClienteRequest.builder()
                .nome("Exemplo Nome")
                .telefone("62999999999")
                .cpf("40049617001")
                .email("teste@email.com")
                .dataNascimento(LocalDate.now())
                .endereco(endereco)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = put(CLIENTE_API + "/" + id).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id " + id + " não encontrado.", response.getMessage());

    }

    @Rollback
    @Test
    void testarAlterarNome_IdValido_RetornarSucesso() throws Exception {

        var estado = estadoRepository.saveAndFlush(Estado.builder()
                .nome("Goias")
                .codigoIBGE("53")
                .uf("GO")
                .build());
        var cidade = cidadeRepository.saveAndFlush(Cidade.builder()
                .nome("São Patricio")
                .codigoIBGE("53100396")
                .estado(estado)
                .build());


        var endereco = Endereco.builder()
                .logradouro("Av B")
                .numero("S/N")
                .complemento("Qd A")
                .bairro("Centro")
                .cidade(cidade)
                .cep("76343000")
                .build();

        Cliente clienteAlterarNome = new Cliente();
        clienteAlterarNome.setId(1L);
        clienteAlterarNome.setNome("Exemplo Ativar");
        clienteAlterarNome.setTelefone("62999999999");
        clienteAlterarNome.setCpf("40049617001");
        clienteAlterarNome.setEmail("teste@email.com");
        clienteAlterarNome.setEndereco(endereco);
        clienteAlterarNome.setDataNascimento(LocalDate.now());

        clienteAlterarNome = clienteRepository.saveAndFlush(clienteAlterarNome);

        final ClienteRequest exemploRequest = ClienteRequest.builder()
                .nome("Alterando...")
                .telefone("62999999998")
                .cpf("40049617001")
                .email("teste@email.com")
                .dataNascimento(LocalDate.now())
                .endereco(clienteAlterarNome.getEndereco())
                .build();

        final MockHttpServletRequestBuilder requestBuilder = put(CLIENTE_API + '/' + clienteAlterarNome.getId()).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final ClienteResponse exemploResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ClienteResponse.class);

        Assertions.assertEquals(clienteAlterarNome.getId(), exemploResponse.getId());
        Assertions.assertEquals(clienteAlterarNome.getNome(), exemploResponse.getNome());

    }

    @Test
    @Rollback
    void testarAtivar_IdInvalido_RetornarError() throws Exception {
        final var id = 2L;

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        final BaseEntityActiveRequest exemploRequest = BaseEntityActiveRequest.builder().ativo(true).build();

        final MockHttpServletRequestBuilder requestBuilder = patch(CLIENTE_API + "/active/" + id).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id " + id + " não encontrado.", response.getMessage());

    }

    @Test
    @Rollback
    void testarInativar_IdValido_RetornarSucesso() throws Exception {

        var estado = estadoRepository.saveAndFlush(Estado.builder()
                .nome("Goias")
                .codigoIBGE("53")
                .uf("GO")
                .build());
        var cidade = cidadeRepository.saveAndFlush(Cidade.builder()
                .nome("São Patricio")
                .codigoIBGE("53100396")
                .estado(estado)
                .build());

        var endereco = Endereco.builder()
                .logradouro("Av B")
                .numero("S/N")
                .complemento("Qd A")
                .bairro("Centro")
                .cidade(cidade)
                .cep("76343000")
                .build();

        final ClienteRequest clienteRequest = ClienteRequest.builder()
                .nome("Alterando...")
                .telefone("62999999998")
                .cpf("40049617001")
                .email("teste@email.com")
                .dataNascimento(LocalDate.now())
                .endereco(endereco)
                .build();

        final MockHttpServletRequestBuilder requestBuilderSave = post(CLIENTE_API).content(objectMapper.writeValueAsString(clienteRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilderSave).andDo(log()).andExpect(status().isCreated());

        objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ExemploResponse.class);


        final var exemploAtivar = clienteRepository.findById(1L).orElse(null);

        final BaseEntityActiveRequest ativarRequest = BaseEntityActiveRequest.builder().ativo(false).build();

        final MockHttpServletRequestBuilder requestBuilder = patch(CLIENTE_API + "/active/" + exemploAtivar.getId())
                .content(objectMapper.writeValueAsString(ativarRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final Cliente exemploResponse = clienteRepository.findById(exemploAtivar.getId()).orElse(null);

        Assertions.assertNotNull(exemploResponse);
        Assertions.assertEquals(exemploAtivar.getId(), exemploResponse.getId());
        Assertions.assertEquals(exemploAtivar.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemploAtivar.getEmail(), exemploResponse.getEmail());

    }
}
