package br.com.tresptecnologia.controller.aquisicao;

import br.com.tresptecnologia.core.controller.model.ErrorResponse;
import br.com.tresptecnologia.entity.cliente.Cidade;
import br.com.tresptecnologia.entity.cliente.Estado;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import br.com.tresptecnologia.model.aquisicao.AquisicaoRequest;
import br.com.tresptecnologia.model.aquisicao.AquisicaoResponse;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.cliente.ClienteResponse;
import br.com.tresptecnologia.model.endereco.EnderecoRequest;
import br.com.tresptecnologia.model.entity.BaseEntityRequest;
import br.com.tresptecnologia.model.pagamento.PagamentoRequest;
import br.com.tresptecnologia.model.procedimento.ProcedimentoMapper;
import br.com.tresptecnologia.repository.cidade.CidadeRepository;
import br.com.tresptecnologia.repository.estado.EstadoRepository;
import br.com.tresptecnologia.repository.procedimento.ProcedimentoRepository;
import br.com.tresptecnologia.support.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@Rollback
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AquisicaoTest extends BaseTest {

    private static final String AQUISICAO_API = "/aquisicao";
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ProcedimentoRepository procedimentoRepository;
    @Autowired
    private ProcedimentoMapper procedimentoMapper;

    @Test
    @Rollback
    void testarConsultar_IdInvalido_RetornarError() throws Exception {
        final MockHttpServletRequestBuilder requestBuilder = get(AQUISICAO_API + "/999").with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id 999 não encontrado.", response.getMessage());

    }

    @Test
    @Rollback
    void testarAdicionar_DadosVazios_RetornarError() throws Exception {
        var aquisicaoRequest = new AquisicaoRequest();
        assertMessages(errorsValidations(AQUISICAO_API, 6, aquisicaoRequest),
                "O campo Data de Aquisição é obrigatório.",
                "O campo Valor do Desconto é obrigatório.",
                "O campo Procedimento é obrigatório.",
                "O campo Cliente é obrigatório.",
                "A lista de Pagamento deve ter no minimo 1 pagamento(s)",
                "O campo Data de Aquisição é obrigatório.");
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


        var endereco = EnderecoRequest.builder()
                .logradouro("Av B")
                .numero("S/N")
                .complemento("Qd A")
                .bairro("Centro")
                .cidade(BaseEntityRequest.of(cidade.getId()))
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

        final var procedimento = procedimentoRepository.save(Procedimento.builder()
                        .valor(800.00)
                        .nome("Teste")
                        .intervaloEntreSessoes(7)
                        .quantidadeSessoes(1)
                .build());

        final var pagamentos = new HashSet<PagamentoRequest>();
        pagamentos.add(PagamentoRequest.builder().build());

        final var aquisicao = AquisicaoRequest.builder()
                .cliente(exemploRequest)
                .pagamentos(pagamentos)
                .procedimento(BaseEntityRequest.builder().id(procedimento.getId()).build())
                .dataAquisicao(LocalDateTime.now())
                .valorAquisicao(800.00)
                .valorDesconto(0.0)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = post(AQUISICAO_API).content(objectMapper.writeValueAsString(aquisicao)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isCreated());

        final AquisicaoResponse aquisicaoResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), AquisicaoResponse.class);

        Assertions.assertNotNull(aquisicaoResponse.getId());
    }
}
