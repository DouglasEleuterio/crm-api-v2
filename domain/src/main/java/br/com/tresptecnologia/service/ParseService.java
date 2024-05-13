package br.com.tresptecnologia.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.service.storage.IStorageService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ParseService {

    private final IStorageService storageService;

    public XML convertArquivoToXml(Arquivo arquivo) throws DomainException {
        try {

            var arquivoIS = storageService.get(arquivo.getBucket(), arquivo.getPath(), arquivo.getNome());

            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(arquivoIS, XML.class);

        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        convertXmlToOjectStatic();
    }

    public static Object convertXmlToOjectStatic() throws Exception {
        File file = new File("C:\\Users\\dougl\\IdeaProjects\\crm-api-v2\\exemplos\\31240417159518000175550010040191551690820399.xml");

        XmlMapper xmlMapper = new XmlMapper();
        Object obj = xmlMapper.readValue(file, Object.class);
        XML XML = xmlMapper.readValue(file, XML.class);
        return obj;
    }

}

