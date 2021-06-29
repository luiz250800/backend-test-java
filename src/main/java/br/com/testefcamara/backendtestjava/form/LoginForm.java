package br.com.testefcamara.backendtestjava.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Classe para forumulário de login.
 */
public class LoginForm {
    @NotNull @NotEmpty
    private String nmEmail;

    @NotNull @NotEmpty
    private String nmPassword;

    public String getNmEmail() {
        return nmEmail;
    }

    public void setNmEmail(String nmEmail) {
        this.nmEmail = nmEmail;
    }

    public String getNmPassword() {
        return nmPassword;
    }

    public void setNmPassword(String nmPassword) {
        this.nmPassword = nmPassword;
    }

    /**
     * Método para converter loginForm em UsernamePasswordAuthenticationToken.
     * @return
     */
    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(nmEmail, nmPassword);
    }
}
