package br.com.tresptecnologia.support;

import br.com.tresptecnologia.core.controller.model.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public abstract class BaseTest extends MessageBaseTest {

    protected final String JSON_CONTENT_TYPE = "application/json; charset=utf-8";

    @Value("${user.name}")
    private String defaultUserName;

    @Value("${user.email}")
    private String defaultEmail;

    @Value("${user.sub}")
    private String defaultSub;

    @Value("${user.roles}")
    private String defaultRoles;

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    private JwtDecoder jwtDecoder;

    public SecurityMockMvcRequestPostProcessors.JwtRequestPostProcessor defaultUserJwt() {
        return configureUserJwt(defaultSub, defaultUserName, defaultEmail, List.of(defaultRoles.split(",")));
    }

    public SecurityMockMvcRequestPostProcessors.JwtRequestPostProcessor configureUserJwt(String sub, String name,
                                                                                         String email, List<String> roles) {
        return SecurityMockMvcRequestPostProcessors.jwt()
                .jwt(token -> token
                        .claim("sub", sub)
                        .claim("name", name)
                        .claim("preferred_username", name)
                        .claim("email", email)
                ).authorities(jwt -> roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet()));
    }

    public void assertMessages(final ResultActions result, String... messages) throws Exception {
        assertMessages(result, Arrays.stream(messages).toList());
    }

    public void assertMessages(final ResultActions result, List<String> messages)
            throws Exception {
        if (result.andReturn().getResponse().getStatus() == 400 && messages != null && messages
                .size() > 0) {
            result.andExpect(jsonPath("$.message").hasJsonPath());
            result.andExpect(jsonPath("$.errors").hasJsonPath());

            final ErrorResponse response = objectMapper.readValue(result.andReturn()
                    .getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorResponse.class);

            List<String> allMessages = response.getAllMessages();
            for (String message : messages) {
                Assertions.assertTrue(allMessages.contains(message));
            }
        }
    }

    public ResultActions errorsValidations(final String path, final Integer errorsSize, final Object objectRequest) throws Exception {
        final var request = post(path)
                .contentType("application/json")
                .with(defaultUserJwt())
                .content(objectMapper.writeValueAsString(objectRequest));

        return mvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors").isNotEmpty())
                .andExpect(jsonPath("$.errors", hasSize(errorsSize)));
    }

}
