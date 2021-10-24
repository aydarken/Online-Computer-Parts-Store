package com.devteam.userregistrationservice;

import com.devteam.userregistrationservice.service.UserRegistrationService;
import com.devteam.userregistrationservice.service.UserRegistrationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class UserRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationServiceApplication.class, args);
	}

	@Bean
	public UserRegistrationService provideUserRegistrationService() {
		return new UserRegistrationServiceImpl();
	}
}
