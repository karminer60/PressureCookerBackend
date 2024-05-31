package com.simpletomate.simpletomatebackend.repositories;

import com.simpletomate.simpletomatebackend.controllers.SimpleTomateController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackageClasses= SimpleTomateController.class)
public class SimpleTomateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTomateBackendApplication.class, args);
	}

}
