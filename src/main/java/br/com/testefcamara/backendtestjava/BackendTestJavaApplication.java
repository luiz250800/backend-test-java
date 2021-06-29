package br.com.testefcamara.backendtestjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe de execução da API.
 */
@SpringBootApplication
@EnableSpringDataWebSupport
@EnableSwagger2
public class BackendTestJavaApplication {

	/**
	 * Método main de execução da API.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BackendTestJavaApplication.class, args);
	}

}
