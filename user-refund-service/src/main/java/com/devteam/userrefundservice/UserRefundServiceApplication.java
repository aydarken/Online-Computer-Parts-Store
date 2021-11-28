package com.devteam.userrefundservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableHystrix
public class UserRefundServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRefundServiceApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate provideRestTemplate() {
		return new RestTemplate();
	}
}
