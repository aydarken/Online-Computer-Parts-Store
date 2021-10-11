package com.devteam.userregistrationservice;

import com.devteam.userregistrationservice.service.UserRegistrationService;
import com.devteam.userregistrationservice.service.UserRegistrationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationServiceApplication.class, args);
	}

	@Bean
	public UserRegistrationService provideUserRegistrationService() {
		return new UserRegistrationServiceImpl();
	}
}
