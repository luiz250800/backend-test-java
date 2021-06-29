package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.User;
import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Classe para formulário de alteração de usuário.
 */
public class UserFormUpdate {
    @NotNull
    @NotEmpty
    private String nmEmail;

    @NotNull @NotEmpty
    private String nmPassword;

    @NotNull @NotEmpty
    private String nmLastPassword;

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

    public String getNmLastPassword() {
        return nmLastPassword;
    }

    public void setNmLastPassword(String nmLastPassword) {
        this.nmLastPassword = nmLastPassword;
    }

    /**
     * Método para alteração e validação de usuário.
     * @param id
     * @param userRepository
     * @return
     */
    public User update(Long id, UserRepository userRepository) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = userRepository.getById(id);

        boolean lastPasswordIsValid = passwordEncoder.matches(this.nmLastPassword, user.getPassword());

        if(lastPasswordIsValid) {
            user.setNmEmail(this.nmEmail);
            user.setNmPassword(passwordEncoder.encode(this.nmPassword));
            return user;
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Senha atual inválida.");
    }
}
