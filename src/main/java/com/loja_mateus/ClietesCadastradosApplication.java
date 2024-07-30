package com.loja_mateus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.loja_mateus.*"})
public class ClietesCadastradosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClietesCadastradosApplication.class, args);
	}

}
