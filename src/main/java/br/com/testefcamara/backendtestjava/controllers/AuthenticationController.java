package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.config.security.TokenService;
import br.com.testefcamara.backendtestjava.dto.TokenDto;
import br.com.testefcamara.backendtestjava.form.LoginForm;
import br.com.testefcamara.backendtestjava.form.UserForm;
import br.com.testefcamara.backendtestjava.form.UserFormUpdate;
import br.com.testefcamara.backendtestjava.models.User;
import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Classe controller para CRUD de usuário.
 */
@RestController
@RequestMapping(value = "/api/auth", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@Profile("prod")
public class AuthenticationController {

    private final AuthenticationManager authentitcationManager;

    private final TokenService tokenService;

    private final UserRepository userRepository;

    /**
     * @param authentitcationManager
     * @param tokenService
     * @param userRepository
     */
    public AuthenticationController(AuthenticationManager authentitcationManager, TokenService tokenService, UserRepository userRepository) {
        this.authentitcationManager = authentitcationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    /**
     * Método para validação de usuário requisitado.
     * @param loginForm
     * @return
     */
    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm loginForm) {
        try {
            UsernamePasswordAuthenticationToken loginData = loginForm.converter();
            Authentication authentication = authentitcationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException exc) {
            return ResponseEntity.badRequest().build();
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para registro de novo usuário.
     * @param userForm
     * @param uriBuilder
     * @return
     */
    @PostMapping(value = "/register")
    @Transactional
    public ResponseEntity<String> register(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {
        try {
            User user = userForm.converter();
            userRepository.save(user);
            return ResponseEntity.status(201).body("Usuário cadastrado com sucesso!");
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para auteração de usuário.
     * @param id
     * @param userFormUpdate
     * @return
     */
    @PutMapping(value = "/update/{id}")
    @Transactional
    public  ResponseEntity<String> update(@PathVariable Long id, @RequestBody @Valid UserFormUpdate userFormUpdate){
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (!userOptional.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
            userFormUpdate.update(id, userRepository);
            return ResponseEntity.ok().body("Usuário alterado com sucesso!");
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    /**
     * Método para exclusão de usuário.
     * @param id
     * @return
     */
    @DeleteMapping(value="/delete/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if(!optionalUser.isPresent())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(ResponseStatusException exc) {
            throw new ResponseStatusException(HttpStatus.resolve(exc.getRawStatusCode()), exc.getReason(), exc.fillInStackTrace());
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }
}
