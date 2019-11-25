package com.customerfarm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.customerfarm.springboot.config.CorsConfig;

@SpringBootApplication
@ComponentScan(basePackageClasses = CorsConfig.class)
@ComponentScan(basePackages = "com.customerfarm.springboot.controllers")
@EnableJpaRepositories("com.customerfarm.springboot.repositories")
@EntityScan("com.customerfarm.springboot.model")
public class CustomerFarmAppApplication {
    

	public static void main(String[] args) {
		SpringApplication.run(CustomerFarmAppApplication.class, args);
	}

}
