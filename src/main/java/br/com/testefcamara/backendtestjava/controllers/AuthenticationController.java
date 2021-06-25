package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.config.security.TokenService;
import br.com.testefcamara.backendtestjava.dto.TokenDto;
import br.com.testefcamara.backendtestjava.errorDto.ErrorDto;
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

@RestController
@RequestMapping(value = "/api/auth", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@Profile("prod")
public class AuthenticationController {

    private final AuthenticationManager authentitcationManager;

    private final TokenService tokenService;

    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationManager authentitcationManager, TokenService tokenService, UserRepository userRepository) {
        this.authentitcationManager = authentitcationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm loginForm) {
        try {
            UsernamePasswordAuthenticationToken loginData = loginForm.converter();
            Authentication authentication = authentitcationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException exc) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {
        try {
            User user = userForm.converter();
            userRepository.save(user);
            return ResponseEntity.status(201).body("Usuário cadastrado com sucesso!");
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    @PutMapping(value = "/update/{id}")
    @Transactional
    public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UserFormUpdate userFormUpdate){
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (!userOptional.isPresent())
                return new ResponseEntity(new ErrorDto(404, "Usuário não encontrado."), HttpStatus.NOT_FOUND);
            userFormUpdate.update(id, userRepository);
            return ResponseEntity.ok().body("Usuário alterado com sucesso!");
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }

    @DeleteMapping(value="/delete/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if(!optionalUser.isPresent())
                return new ResponseEntity(new ErrorDto(404, "Usuário não encontrado."), HttpStatus.NOT_FOUND);
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor.", exc.fillInStackTrace());
        }
    }
}
