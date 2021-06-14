package br.com.testefcamara.backendtestjava.form;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginFormTest {
    @Test
    public void testaConverterRetornaSenhaCriptografada() {
        LoginForm loginForm = new LoginForm();

        loginForm.setNmEmail("admin@gmail.com");
        loginForm.setNmPassword("admin123");

        Assertions.assertEquals(new UsernamePasswordAuthenticationToken("admin@gmail.com", "admin123"), loginForm.converter());
    }
}
