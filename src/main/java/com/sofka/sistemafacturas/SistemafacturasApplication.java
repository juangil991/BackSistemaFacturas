package com.sofka.sistemafacturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SistemafacturasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemafacturasApplication.class, args);
	}

}
