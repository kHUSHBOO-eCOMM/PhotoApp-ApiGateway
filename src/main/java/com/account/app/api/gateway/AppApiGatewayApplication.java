package com.account.app.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApiGatewayApplication.class, args);
	}

}
