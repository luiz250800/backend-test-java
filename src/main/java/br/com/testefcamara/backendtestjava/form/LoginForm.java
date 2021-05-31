package br.com.testefcamara.backendtestjava.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
    private String nmEmail;

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

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(nmEmail, nmPassword);
    }
}
