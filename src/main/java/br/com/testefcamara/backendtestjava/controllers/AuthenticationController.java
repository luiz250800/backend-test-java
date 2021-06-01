package br.com.testefcamara.backendtestjava.controllers;

import br.com.testefcamara.backendtestjava.config.security.TokenService;
import br.com.testefcamara.backendtestjava.dto.TokenDto;
import br.com.testefcamara.backendtestjava.form.LoginForm;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Profile("prod")
public class AuthenticationController {

    private final AuthenticationManager authentitcationManager;

    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authentitcationManager, TokenService tokenService) {
        this.authentitcationManager = authentitcationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken loginData = loginForm.converter();

        try {
            Authentication authentication = authentitcationManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
