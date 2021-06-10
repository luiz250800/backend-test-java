package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.User;
import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

@DataJpaTest
@ActiveProfiles("prod")
public class UserFormUpdateTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testaConverterRetornaSenhaCriptografadaCorretamente() {
        UserFormUpdate userFormUpdate = new UserFormUpdate();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        userFormUpdate.setNmEmail("admin@gmail.com");
        userFormUpdate.setNmPassword("admin1234");
        userFormUpdate.setNmLastPassword("admin123");

        User user = userFormUpdate.update(1L, userRepository);

        Assertions.assertNotNull(user.getPassword());
        Assertions.assertNotEquals("", user.getPassword());
        Assertions.assertNotEquals("admin1234", user.getPassword());
        Assertions.assertTrue(passwordEncoder.matches("admin1234", user.getPassword()));
    }

    @Test
    public void testaConverterRetornaSenhaAtualInvalida() {
        UserFormUpdate userFormUpdate = new UserFormUpdate();

        userFormUpdate.setNmEmail("admin@gmail.com");
        userFormUpdate.setNmPassword("admin123");
        userFormUpdate.setNmLastPassword("abc123");

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> userFormUpdate.update(1L, userRepository));
        Assertions.assertEquals(HttpStatus.FORBIDDEN + " \"Senha atual inválida.\"", thrown.getMessage());
    }
}
