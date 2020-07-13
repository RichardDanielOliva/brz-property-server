package com.brz.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BrzConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrzConfigServerApplication.class, args);
	}

}
