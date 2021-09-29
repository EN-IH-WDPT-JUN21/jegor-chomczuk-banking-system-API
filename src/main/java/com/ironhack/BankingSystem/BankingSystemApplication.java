package com.ironhack.BankingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
		PasswordEncoder pwdEnconder = new BCryptPasswordEncoder();
		System.out.println("Password '123456' is: " + pwdEnconder.encode("123456"));
	}
}
