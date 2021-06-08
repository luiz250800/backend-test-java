package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.User;
import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("prod")
public class UserFormUpdateTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testaConverterRetornaSenhaCriptografada() {
        UserFormUpdate userFormUpdate = new UserFormUpdate();

        userFormUpdate.setNmEmail("admin@gmail.com");
        userFormUpdate.setNmPassword("admin123");
        userFormUpdate.setNmLastPassword("abc123");

    }
}
