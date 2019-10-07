package br.com.siberius.restwithspringboot;

import br.com.siberius.restwithspringboot.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageConfig.class
})
public class RestWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootApplication.class, args);
	}

}
