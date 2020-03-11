package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
@RestController
public class SBHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBHelloWorldApplication.class, args);
	}

	@GetMapping("/")
	public Greet sayHello() {

		return new Greet("Hello World");
	}

	@GetMapping("/scream")
	public Greet screamLoud(@RequestParam(name = "message") String message) {

		return new Greet(new StringBuilder(message).reverse().toString().toUpperCase());
	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Greet {
	private String message;

}
