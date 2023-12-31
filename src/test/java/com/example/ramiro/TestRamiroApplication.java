package com.example.ramiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestRamiroApplication {

	public static void main(String[] args) {
		SpringApplication.from(RamiroApplication::main).with(TestRamiroApplication.class).run(args);
	}

}
