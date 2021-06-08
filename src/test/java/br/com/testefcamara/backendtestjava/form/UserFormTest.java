package br.com.testefcamara.backendtestjava.form;

import br.com.testefcamara.backendtestjava.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("prod")
public class UserFormTest {

    @Test
    public void testaConverterRetornaSenhaCriptografada() {
        UserForm userForm = new UserForm();

        userForm.setNmEmail("admin@gmail.com");
        userForm.setNmPassword("admin123");

        User user = userForm.converter();

        Assertions.assertNotNull(user.getPassword());
        Assertions.assertNotEquals("", user.getPassword());
        Assertions.assertNotEquals("admin123", user.getPassword());
    }
}
