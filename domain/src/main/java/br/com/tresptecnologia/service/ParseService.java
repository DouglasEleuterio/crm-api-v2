package br.com.tresptecnologia.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.repository.xmlrepository.XmlRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Service
public class ParseService {

    private final XmlRepository repository;

    public ParseService(XmlRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public XML convertXmlToOject(String enderecoXml) throws DomainException {
        try {
            enderecoXml = "C:\\Users\\dougl\\IdeaProjects\\crm-api-v2\\exemplos\\31240443214055000107550000225488061763699484.xml";
            File file = new File(enderecoXml);
            XmlMapper xmlMapper = new XmlMapper();
            XML obj = xmlMapper.readValue(file, XML.class);
            return repository.save(obj);

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

