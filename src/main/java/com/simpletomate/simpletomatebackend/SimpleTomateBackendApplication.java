package com.simpletomate.simpletomatebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SimpleTomateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTomateBackendApplication.class, args);
	}

}
