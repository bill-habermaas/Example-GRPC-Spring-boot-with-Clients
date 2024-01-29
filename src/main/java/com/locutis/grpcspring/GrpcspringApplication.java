package com.locutis.grpcspring;

import com.locutis.grpcspring.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(AppConfig.class)
public class GrpcspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcspringApplication.class, args);
	}

}
