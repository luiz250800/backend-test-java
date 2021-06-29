package br.com.testefcamara.backendtestjava.config.security;

import br.com.testefcamara.backendtestjava.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Classe para definição das funções de token.
 */
@Service
public class TokenService {

    @Value("${backend-test-java.jwt.expiration}")
    private String expiration;

    @Value("${backend-test-java.jwt.secret}")
    private String secret;

    /**
     * Método de geração do token de acesso.
     * @param authentication
     * @return
     */
    public String generateToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();
        Date today = new Date();
        Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder().setIssuer("Backend-test-java")
                .setSubject(logged.getId().toString())
                .setIssuedAt(today).setExpiration(dateExpiration).signWith(SignatureAlgorithm.HS256, secret).compact();
        }

    /**
     * Método de validação de token.
     * @param token
     * @return
     */
    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método para identificação de usuário para determinado token.
     * @param token
     * @return
     */
    public Long getIdUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
