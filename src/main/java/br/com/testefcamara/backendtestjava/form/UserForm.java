package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Classe para forumulário de usuário.
 */
public class UserForm {

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
     * Método para converter UserForm para User e criptografar password.
     * @return
     */
    public User converter() {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setNmEmail(nmEmail);
        user.setNmPassword(passwordEncoder.encode(nmPassword));

        return user;
    }
}
