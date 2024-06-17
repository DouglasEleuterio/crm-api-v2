package br.com.tresptecnologia.controller.aquisicao;

import br.com.tresptecnologia.core.controller.model.ErrorResponse;
import br.com.tresptecnologia.entity.cliente.Cidade;
import br.com.tresptecnologia.entity.cliente.Estado;
import br.com.tresptecnologia.entity.pagamento.EFormaPagamento;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import br.com.tresptecnologia.model.aquisicao.AquisicaoRequest;
import br.com.tresptecnologia.model.aquisicao.AquisicaoResponse;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.endereco.EnderecoRequest;
import br.com.tresptecnologia.model.entity.BaseEntityRequest;
import br.com.tresptecnologia.model.pagamento.PagamentoRequest;
import br.com.tresptecnologia.model.parecelapagamento.ParcelaPagamentoRequest;
import br.com.tresptecnologia.repository.cidade.CidadeRepository;
import br.com.tresptecnologia.repository.estado.EstadoRepository;
import br.com.tresptecnologia.repository.procedimento.ProcedimentoRepository;
import br.com.tresptecnologia.service.procedimento.ProcedimentoService;
import br.com.tresptecnologia.support.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    @SpyBean
    private ProcedimentoRepository procedimentoRepository;
    @Mock
    private ProcedimentoService procedimentoService;

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
                "O campo Valor da Aquisição é obrigatório." );
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

        var parcelas = new HashSet<ParcelaPagamentoRequest>();
        parcelas.add(ParcelaPagamentoRequest.builder()
                        .dataCredito(LocalDate.now())
                        .isRecebido(false)
                        .valorCredito(262.66)
                        .valorTaxa(4.00)
                        .numeroParcela(1)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                        .dataCredito(LocalDate.now())
                        .isRecebido(false)
                        .valorCredito(262.66)
                        .valorTaxa(4.00)
                        .numeroParcela(2)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                        .dataCredito(LocalDate.now())
                        .isRecebido(false)
                        .valorCredito(262.68)
                        .valorTaxa(4.00)
                        .numeroParcela(3)
                .build());

        final var pagamentos = new HashSet<PagamentoRequest>();
        pagamentos.add(PagamentoRequest.builder()
                .dataPagamento(LocalDateTime.now())
                        .formaPagamento(EFormaPagamento.CARTAO_CREDITO)
                        .taxa(12.00)
                        .quantidadeParcelas(3)
                        .valorPagamento(800.00)
                        .pagamentos(parcelas)
                .build());

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

    @Test
    @Rollback
    void testarAdicionar_valorAquisicaoSuperiorAoPagamento_RetornarErro() throws Exception {
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

        var parcelas = new HashSet<ParcelaPagamentoRequest>();
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(1)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(2)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.68)
                .valorTaxa(4.00)
                .numeroParcela(3)
                .build());

        final var pagamentos = new HashSet<PagamentoRequest>();
        pagamentos.add(PagamentoRequest.builder()
                .dataPagamento(LocalDateTime.now())
                .formaPagamento(EFormaPagamento.CARTAO_CREDITO)
                .taxa(12.00)
                .quantidadeParcelas(3)
                .valorPagamento(800.00)
                .pagamentos(parcelas)
                .build());

        final var aquisicao = AquisicaoRequest.builder()
                .cliente(exemploRequest)
                .pagamentos(pagamentos)
                .procedimento(BaseEntityRequest.builder().id(procedimento.getId()).build())
                .dataAquisicao(LocalDateTime.now())
                .valorAquisicao(700.00)
                .valorDesconto(0.0)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = post(AQUISICAO_API).content(objectMapper.writeValueAsString(aquisicao)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse errorResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertNotNull(errorResponse.getMessage());
        Assertions.assertTrue(errorResponse.getMessage().contains("menor que o valor do procedimento"));
    }

        @Test
        @Rollback
        void testarAdicionar_valorPagamentosInferiorAquisicao_RetornarErro() throws Exception {
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

            var parcelas = new HashSet<ParcelaPagamentoRequest>();
            parcelas.add(ParcelaPagamentoRequest.builder()
                    .dataCredito(LocalDate.now())
                    .isRecebido(false)
                    .valorCredito(262.66)
                    .valorTaxa(4.00)
                    .numeroParcela(1)
                    .build());
            parcelas.add(ParcelaPagamentoRequest.builder()
                    .dataCredito(LocalDate.now())
                    .isRecebido(false)
                    .valorCredito(262.66)
                    .valorTaxa(4.00)
                    .numeroParcela(2)
                    .build());
            parcelas.add(ParcelaPagamentoRequest.builder()
                    .dataCredito(LocalDate.now())
                    .isRecebido(false)
                    .valorCredito(262.68)
                    .valorTaxa(4.00)
                    .numeroParcela(3)
                    .build());

            final var pagamentos = new HashSet<PagamentoRequest>();
            pagamentos.add(PagamentoRequest.builder()
                    .dataPagamento(LocalDateTime.now())
                    .formaPagamento(EFormaPagamento.CARTAO_CREDITO)
                    .taxa(12.00)
                    .quantidadeParcelas(3)
                    .valorPagamento(700.00)
                    .pagamentos(parcelas)
                    .build());

            final var aquisicao = AquisicaoRequest.builder()
                    .cliente(exemploRequest)
                    .pagamentos(pagamentos)
                    .procedimento(BaseEntityRequest.builder().id(procedimento.getId()).build())
                    .dataAquisicao(LocalDateTime.now())
                    .valorAquisicao(800.00)
                    .valorDesconto(0.0)
                    .build();

            final MockHttpServletRequestBuilder requestBuilder = post(AQUISICAO_API).content(objectMapper.writeValueAsString(aquisicao)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

            final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

            final ErrorResponse errorResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

            Assertions.assertNotNull(errorResponse.getMessage());
            Assertions.assertTrue(errorResponse.getMessage().contains("pode ser inferior"));
    }

    @Test
    @Rollback
    void testarAdicionar_valorTotalParcelasInferiorValorPagamento_RetornarErro() throws Exception {
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

        var parcelas = new HashSet<ParcelaPagamentoRequest>();
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(1)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(2)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(3)
                .build());

        final var pagamentos = new HashSet<PagamentoRequest>();
        pagamentos.add(PagamentoRequest.builder()
                .dataPagamento(LocalDateTime.now())
                .formaPagamento(EFormaPagamento.CARTAO_CREDITO)
                .taxa(12.00)
                .quantidadeParcelas(3)
                .valorPagamento(800.00)
                .pagamentos(parcelas)
                .build());

        final var aquisicao = AquisicaoRequest.builder()
                .cliente(exemploRequest)
                .pagamentos(pagamentos)
                .procedimento(BaseEntityRequest.builder().id(procedimento.getId()).build())
                .dataAquisicao(LocalDateTime.now())
                .valorAquisicao(800.00)
                .valorDesconto(0.0)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = post(AQUISICAO_API).content(objectMapper.writeValueAsString(aquisicao)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse errorResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertNotNull(errorResponse.getMessage());
        Assertions.assertTrue(errorResponse.getMessage().contains("pode ser inferior ao valor do pagamento"));
    }

    @Test
    @Rollback
    void testarAtualizar_dadosValidos_RetornarSucesso() throws Exception {
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

        when( procedimentoRepository.findById(1L)).thenReturn(Optional.of(procedimento));

        var parcelas = new HashSet<ParcelaPagamentoRequest>();
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(1)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.66)
                .valorTaxa(4.00)
                .numeroParcela(2)
                .build());
        parcelas.add(ParcelaPagamentoRequest.builder()
                .dataCredito(LocalDate.now())
                .isRecebido(false)
                .valorCredito(262.68)
                .valorTaxa(4.00)
                .numeroParcela(3)
                .build());

        final var pagamentos = new HashSet<PagamentoRequest>();
        pagamentos.add(PagamentoRequest.builder()
                .dataPagamento(LocalDateTime.now())
                .formaPagamento(EFormaPagamento.CARTAO_CREDITO)
                .taxa(12.00)
                .quantidadeParcelas(3)
                .valorPagamento(800.00)
                .pagamentos(parcelas)
                .build());

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


        final MockHttpServletRequestBuilder requestBuilderUpdate = put(AQUISICAO_API + "/" + aquisicaoResponse.getId()).content(objectMapper.writeValueAsString(aquisicaoResponse)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions resultUpdate = mvc.perform(requestBuilderUpdate).andDo(log()).andExpect(status().isOk());

        final AquisicaoResponse aquisicaoResponseUpdate = objectMapper.readValue(resultUpdate.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), AquisicaoResponse.class);

        Assertions.assertNotNull(aquisicaoResponseUpdate.getId());
    }
}
