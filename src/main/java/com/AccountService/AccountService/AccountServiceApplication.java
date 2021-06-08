package com.AccountService.AccountService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class AccountServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "account-server");
		SpringApplication.run(AccountServiceApplication.class, args);
	}

}
