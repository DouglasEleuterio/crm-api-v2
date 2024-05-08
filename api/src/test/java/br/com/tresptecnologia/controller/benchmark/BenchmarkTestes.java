package br.com.tresptecnologia.controller.benchmark;

import br.com.tresptecnologia.model.benchmark.ExemploRootWithManyIdResponse;
import br.com.tresptecnologia.model.benchmark.IExemploRootMapper;
import br.com.tresptecnologia.core.jpa.mapper.Row;
import br.com.tresptecnologia.core.jpa.mapper.exception.JsonMapperException;
import br.com.tresptecnologia.core.jpa.mapper.impl.DefaultJsonMapper;
import br.com.tresptecnologia.repository.benchmark.ExemploRootRepository;
import br.com.tresptecnologia.support.ThreadMemoryInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Rollback
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BenchmarkTestes {

    @Autowired
    ExemploRootRepository exemploRootRepository;

    @Autowired
    IExemploRootMapper exemploRootMapper;

    @MockBean
    JwtDecoder decoder;

    @Test
    @Rollback
    @DisplayName("Teste executando o select e mapeamento para model: Forma Tradicional")
    void testExecutarConsultaComMapeamentoTradicional() {
        ThreadMemoryInfo threadMemoryInfo = new ThreadMemoryInfo();

        threadMemoryInfo.init();

        Page<ExemploRootWithManyIdResponse> response = exemploRootRepository
                .findAll(PageRequest.of(0, 1000))
                .map(x -> exemploRootMapper.toMany(x));

        Assertions.assertNotNull(response);

        threadMemoryInfo.log();
    }

    @DisplayName("Teste executando o select e mapeamento para model: FOR")
    @Test
    @Rollback
    void testExecutarConsultaComMapeamentoJson() throws JsonMapperException {
        ThreadMemoryInfo threadMemoryInfo = new ThreadMemoryInfo();

        threadMemoryInfo.init();

        List<Row> rows = exemploRootRepository.fetch(List.of(
                "id",
                "nome",
                "filhoOne.id",
                "filhoOne.descricao",
                "filhosMany.id"
        ), null, 0, 1000);

        final var jsonMapper = new DefaultJsonMapper(new ObjectMapper());
        final var jsonArray = jsonMapper.toJsonArray(rows);

        Assertions.assertNotNull(jsonArray);

        threadMemoryInfo.log();
    }
}
