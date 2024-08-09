package com.laboratorio_fisica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.laboratorio_fisica.model")
@ComponentScan(basePackages = {"com.laboratorio_fisica.*"})
@EnableJpaRepositories(basePackages = {"com.laboratorio_fisica.repository"})
@EnableTransactionManagement
public class labFisicaApplication {


	public static void main(String[] args) {
		SpringApplication.run(labFisicaApplication.class, args);
	}

}
