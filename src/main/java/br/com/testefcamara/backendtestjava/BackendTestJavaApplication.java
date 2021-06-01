package br.com.testefcamara.backendtestjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BackendTestJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestJavaApplication.class, args);
	}

}
