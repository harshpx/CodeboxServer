package com.codeboxes.CodeboxServer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CodeboxServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeboxServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr() {
		return runner -> System.out.println("Api is running!");
	}
}
