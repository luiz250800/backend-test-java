package br.com.testefcamara.backendtestjava.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("prod")
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${backend-test-java.uri-project}")
    private String uriProject;

    @Test
    public void testaLoginComDadosIncorretos() throws Exception {
        URI uri = new URI(uriProject + "api/auth");
        String json = "{\"nmEmail\":\"emailInvalido@gmail.com\",\"nmPassword\":\"abc123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void testaLoginComDadosCorretos() throws Exception {
        URI uri = new URI(uriProject + "api/auth");
        String json = "{\"nmEmail\":\"admin@gmail.com\",\"nmPassword\":\"admin123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
