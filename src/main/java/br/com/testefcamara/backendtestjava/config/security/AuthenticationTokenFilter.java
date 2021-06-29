package br.com.testefcamara.backendtestjava.config.security;

import br.com.testefcamara.backendtestjava.models.User;
import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Classe TokenFilter para validação de dados de usuário.
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    private UserRepository userRepository;

    /**
     * Construtor recebendo injeção de dependência de tokenService e UserRepository.
     * @param tokenService
     * @param userRepository
     */
    public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    /**
     * Método para verificar se o token passado é válido.
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = recoverToken(httpServletRequest);
        boolean valid = tokenService.isValidToken(token);
        if(valid) {
            authenticateUser(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    /**
     * Validando usuário e definindo suas autorizações.
     * @param token
     */
    private void authenticateUser(String token) {
        Long idUser = tokenService.getIdUser(token);
        User user = userRepository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    /**
     * Validando string de token passado.
     * @param httpServletRequest
     * @return
     */
    private String recoverToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
