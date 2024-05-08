package br.com.tresptecnologia.controller.exemplo;

import br.com.tresptecnologia.core.controller.model.ErrorResponse;
import br.com.tresptecnologia.entity.Exemplo;
import br.com.tresptecnologia.model.entity.BaseEntityActiveRequest;
import br.com.tresptecnologia.model.exemplo.ExemploNomeRequest;
import br.com.tresptecnologia.model.exemplo.ExemploRequest;
import br.com.tresptecnologia.model.exemplo.ExemploResponse;
import br.com.tresptecnologia.repository.exemplo.ExemploRepository;
import br.com.tresptecnologia.support.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
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
class ExemploTests extends BaseTest {

    private final String EXEMPLO_API = "/exemplos";

    @SpyBean
    private ExemploRepository exemploRepository;

    @Mock
    private Exemplo exemplo;

    private EasyRandom easyRandom;

    @BeforeEach
    public void setUp() {
        Mockito.reset(exemploRepository);
    }

    @Test
    @Rollback
    void testarConsultar_IdInvalido_RetornarError() throws Exception {
        final MockHttpServletRequestBuilder requestBuilder = get(EXEMPLO_API + "/999").with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

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
        when(exemplo.getId()).thenReturn(id);
        when(exemplo.getNome()).thenReturn("Nome Teste");
        when(exemplo.getDescricao()).thenReturn("Descrição Teste");

        when(exemploRepository.findById(id)).thenReturn(Optional.of(exemplo));

        final MockHttpServletRequestBuilder requestBuilder = get(EXEMPLO_API + "/" + id).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final ExemploResponse exemploResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ExemploResponse.class);

        Assertions.assertEquals(exemplo.getId(), exemploResponse.getId());
        Assertions.assertEquals(exemplo.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemplo.getDescricao(), exemploResponse.getDescricao());

    }

    @Test
    @Rollback
    void testarAdicionar_DadosVazios_RetornarError() throws Exception {
        assertMessages(errorsValidations(EXEMPLO_API, 2, new ExemploRequest()),
                "O campo Situação é obrigatório.","O campo Nome é obrigatório.");
    }

    @Test
    @Rollback
    void testarAdicionar_DadosValidos_RetornarOk() throws Exception {
        final ExemploRequest exemploRequest = ExemploRequest.builder()
                .id(999L)
                .nome("Exemplo Nome")
                .descricao("Descrição ")
                .situacao(true)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = post(EXEMPLO_API).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isCreated());

        final ExemploResponse exemploResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ExemploResponse.class);

        Assertions.assertNotNull(exemploResponse.getId());
        Assertions.assertEquals(exemploRequest.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemploRequest.getDescricao(), exemploResponse.getDescricao());
    }

    @Test
    @Rollback
    void testarAtualizar_DadosValidos_RetornarOk() throws Exception {
        Exemplo exemploInsert = new Exemplo();
        exemploInsert.setId(2L);
        exemploInsert.setNome("Exemplo");
        exemploInsert.setDescricao("Descrição de Ativar");

        exemploInsert = exemploRepository.saveAndFlush(exemploInsert);

        final ExemploRequest exemploRequest = ExemploRequest.builder()
                .id(2L)
                .nome("Adicionar Atualizado")
                .descricao("Descrição Atualizado")
                .situacao(true)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = put(EXEMPLO_API + "/" + exemploInsert.getId()).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final ExemploResponse exemploResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ExemploResponse.class);

        Assertions.assertEquals(exemploInsert.getId(), exemploResponse.getId());
        Assertions.assertEquals(exemploRequest.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemploRequest.getDescricao(), exemploResponse.getDescricao());
    }

    @Test
    @Rollback
    void testarAtualizar_DadosVazios_RetornarError() throws Exception {
        ExemploRequest exemploRequest = ExemploRequest.builder().build();

        final MockHttpServletRequestBuilder requestBuilder = put(EXEMPLO_API + "/1").content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        assertMessages(result, "O campo Nome é obrigatório.");

    }

    @Test
    @Rollback
    void testarAtualizar_IdInvalido_RetornarError() throws Exception {

        final var id = 2L;

        when(exemploRepository.findById(id)).thenReturn(Optional.empty());

        final ExemploRequest exemploRequest = ExemploRequest.builder()
                .id(1L)
                .nome("Adicionar Atualizado")
                .descricao("Descrição Atualizado")
                .situacao(true)
                .build();

        final MockHttpServletRequestBuilder requestBuilder = put(EXEMPLO_API + "/" + id).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id " + id + " não encontrado.", response.getMessage());

    }

    @Test
    @Rollback
    void testarAlterarNome_IdInvalido_RetornarError() throws Exception {

        final var id = 2L;

        when(exemploRepository.findById(id)).thenReturn(Optional.empty());

        final ExemploNomeRequest exemploRequest = ExemploNomeRequest.builder().nome("Alterando...").build();

        final MockHttpServletRequestBuilder requestBuilder = patch(EXEMPLO_API + "/atualizar-nome/" + id).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id " + id + " não encontrado.", response.getMessage());

    }

    @Test
    @Rollback
    void testarAlterarNome_IdValido_RetornarSucesso() throws Exception {
        Exemplo exemploAlterarNome = new Exemplo();
        exemploAlterarNome.setId(2L);
        exemploAlterarNome.setNome("Exemplo Ativar");
        exemploAlterarNome.setDescricao("Descrição de Ativar");

        exemploAlterarNome = exemploRepository.saveAndFlush(exemploAlterarNome);

        final ExemploNomeRequest exemploRequest = ExemploNomeRequest.builder().nome("Alterando...").build();

        final MockHttpServletRequestBuilder requestBuilder = patch(EXEMPLO_API + "/atualizar-nome/" + exemploAlterarNome.getId()).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final ExemploResponse exemploResponse = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ExemploResponse.class);

        Assertions.assertEquals(exemploAlterarNome.getId(), exemploResponse.getId());
        Assertions.assertEquals(exemploAlterarNome.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemploAlterarNome.getDescricao(), exemploResponse.getDescricao());

    }

    @Test
    @Rollback
    void testarAtivar_IdValido_RetornarSucesso() throws Exception {
        Exemplo exemploAtivar = new Exemplo();
        exemploAtivar.setId(2L);
        exemploAtivar.setNome("Exemplo Ativar");
        exemploAtivar.setDescricao("Descrição de Ativar");
        exemploAtivar.setSituacao(true);

        exemploAtivar = exemploRepository.saveAndFlush(exemploAtivar);

        final BaseEntityActiveRequest ativarRequest = BaseEntityActiveRequest.builder().ativo(true).build();

        final MockHttpServletRequestBuilder requestBuilder = patch(EXEMPLO_API + "/active/" + exemploAtivar.getId()).content(objectMapper.writeValueAsString(ativarRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final Exemplo exemploResponse = exemploRepository.findById(exemploAtivar.getId()).orElse(null);

        Assertions.assertNotNull(exemploResponse);
        Assertions.assertEquals(exemploAtivar.getId(), exemploResponse.getId());
        Assertions.assertEquals(exemploAtivar.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemploAtivar.getDescricao(), exemploResponse.getDescricao());

    }

    @Test
    @Rollback
    void testarInativar_IdValido_RetornarSucesso() throws Exception {
        final var exemploAtivar = exemploRepository.findById(1L).orElse(null);

        final BaseEntityActiveRequest ativarRequest = BaseEntityActiveRequest.builder().ativo(false).build();

        final MockHttpServletRequestBuilder requestBuilder = patch(EXEMPLO_API + "/active/" + exemploAtivar.getId())
                .content(objectMapper.writeValueAsString(ativarRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        mvc.perform(requestBuilder).andDo(log()).andExpect(status().isOk());

        final Exemplo exemploResponse = exemploRepository.findById(exemploAtivar.getId()).orElse(null);

        Assertions.assertNotNull(exemploResponse);
        Assertions.assertEquals(exemploAtivar.getId(), exemploResponse.getId());
        Assertions.assertEquals(exemploAtivar.getNome(), exemploResponse.getNome());
        Assertions.assertEquals(exemploAtivar.getDescricao(), exemploResponse.getDescricao());

    }

    @Test
    @Rollback
    void testarAtivar_IdInvalido_RetornarError() throws Exception {
        final var id = 2L;

        when(exemploRepository.findById(id)).thenReturn(Optional.empty());

        final BaseEntityActiveRequest exemploRequest = BaseEntityActiveRequest.builder().ativo(true).build();

        final MockHttpServletRequestBuilder requestBuilder = patch(EXEMPLO_API + "/active/" + id).content(objectMapper.writeValueAsString(exemploRequest)).with(defaultUserJwt()).contentType(JSON_CONTENT_TYPE);

        final ResultActions result = mvc.perform(requestBuilder).andDo(log()).andExpect(status().isBadRequest());

        final ErrorResponse response = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

        Assertions.assertEquals("Registro de id " + id + " não encontrado.", response.getMessage());

    }
}
