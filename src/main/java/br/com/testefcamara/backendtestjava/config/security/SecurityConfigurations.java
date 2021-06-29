package br.com.testefcamara.backendtestjava.config.security;

import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Classe com configrações de PRODUÇÃO para restrição de rotas.
 */
@EnableWebSecurity
@Configuration
@Profile("prod")
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    private final TokenService tokenService;

    private final UserRepository userRepository;

    /**
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * Recebendo injeção de dependência com servidor de autenticação, de token e userRepository.
     * @param authenticationService
     * @param tokenService
     * @param userRepository
     */
    public SecurityConfigurations(AuthenticationService authenticationService, TokenService tokenService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }


    /**
     * Definindo configuração de autenticação com BCrypt.
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * Determina quais rotas http serão permitidas sem necessidade de autenticação.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/company").permitAll()
                .antMatchers(HttpMethod.GET, "/api/company*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/vehicle").permitAll()
                .antMatchers(HttpMethod.GET, "/api/vehicle*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/*").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilterBefore(new AuthenticationTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Determina quais rotas serão ignoradas ao restringi-las.
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }
}
