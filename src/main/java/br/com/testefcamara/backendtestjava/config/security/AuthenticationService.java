package br.com.testefcamara.backendtestjava.config.security;

import br.com.testefcamara.backendtestjava.models.User;
import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe service para validar usuário no banco de dados
 */
@Service
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Construtor recebe injeção de dependência de userRepository para efetuar consultas.
     * @param userRepository
     */
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Valida se e-mail informado existe no banco de dados.
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByNmEmail(username);
        if (user.isPresent()){
            return user.get();
        }

        throw new UsernameNotFoundException("Usuário ou senha inválido.");
    }
}
