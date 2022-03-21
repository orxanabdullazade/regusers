package com.dmx.regusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RegusersApplication {

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(RegusersApplication.class, args);
	}

}
