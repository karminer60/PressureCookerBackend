package com.simpletomate;

import com.simpletomate.controllers.SimpleTomateController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackageClasses= SimpleTomateController.class)
@EnableJpaRepositories
public class SimpleTomateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTomateBackendApplication.class, args);
	}

}
