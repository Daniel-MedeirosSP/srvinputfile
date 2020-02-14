package com.medeirosdaniel.srvinputfile;

import com.medeirosdaniel.srvinputfile.Security.EncriptaSecurity;
import com.medeirosdaniel.srvinputfile.Security.ValidaLoginSecurity;
import com.medeirosdaniel.srvinputfile.Storage.StorageProperties;
import com.medeirosdaniel.srvinputfile.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SrvinputfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvinputfileApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}



}
