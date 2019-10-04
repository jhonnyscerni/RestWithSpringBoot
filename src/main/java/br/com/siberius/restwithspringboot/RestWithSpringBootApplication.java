package br.com.siberius.restwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootApplication.class, args);
	}

		//Caso queira gerar um senha BCryptPasswordEncoder de 16
		/*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("admin123");
		System.out.println("My hash " + result);*/
}
