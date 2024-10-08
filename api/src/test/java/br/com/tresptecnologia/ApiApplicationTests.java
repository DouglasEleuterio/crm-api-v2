package br.com.tresptecnologia;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ApiApplicationTests {

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private JwtDecoder jwtDecoder;

    @Test
    void contextLoads() {
        Assertions.assertTrue(true);
    }

}
