package com.ding.xxx_crud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class XxxCrudApplication {


	public static void main(String[] args) {
		SpringApplication.run(XxxCrudApplication.class, args);
		System.out.println("第sep 18版");
	}

//	@Bean
//	public ApplicationRunner xxx(PasswordEncoder passwordEncoder) {
//		return args -> {
//			System.out.println("=== BCrypt ApplicationRunner encode 結果 ===");
//			System.out.println(passwordEncoder.encode("a1"));
//		};
//	}
}
