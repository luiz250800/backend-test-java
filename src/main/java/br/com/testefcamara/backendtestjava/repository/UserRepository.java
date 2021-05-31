package br.com.testefcamara.backendtestjava.repository;

import br.com.testefcamara.backendtestjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNmEmail(String nmEmail);
}
