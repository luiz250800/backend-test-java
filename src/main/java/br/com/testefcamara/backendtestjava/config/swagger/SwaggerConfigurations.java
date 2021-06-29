package br.com.testefcamara.backendtestjava.config.swagger;

import br.com.testefcamara.backendtestjava.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

/**
 * Classe com configurações do Swagger.
 */
@Configuration
public class SwaggerConfigurations {

    /**
     * Método com as configurações do Swagger do projeto.
     * @return
     */
    @Bean
    public Docket backendTestJavaapi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.testefcamara.backendtestjava"))
                .paths(PathSelectors.ant("/**")).build().ignoredParameterTypes(User.class)
                .globalOperationParameters(Arrays.asList(
                                                        new ParameterBuilder().name("Authorization")
                                                                .description("Header token JWT")
                                                                .modelRef(new ModelRef("string"))
                                                                .parameterType("header").required(false)
                                                                .build()));
    }

}