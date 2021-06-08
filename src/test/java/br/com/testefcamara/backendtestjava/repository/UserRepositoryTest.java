package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.form.UserForm;
import br.com.testefcamara.backendtestjava.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("prod")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testaUsuarioExistente() {
        Optional<User> user = userRepository.findByNmEmail("admin@gmail.com");
        Assertions.assertEquals("admin@gmail.com" , user.get().getNmEmail());
    }

    @Test
    public void testaUsuarioInexistente() {
        Optional<User> user = userRepository.findByNmEmail("abc@gmail.com");
        Assertions.assertEquals(Optional.empty() , user);
    }

}
