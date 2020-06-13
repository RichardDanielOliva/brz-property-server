package com.brv.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		MongoAutoConfiguration.class, 
		MongoDataAutoConfiguration.class})
public class BrzSecurityOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrzSecurityOauthApplication.class, args);
	}

}
