package com.exercise.advertise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebMvc
@ComponentScan
@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
public class AdvertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertiseApplication.class, args);
	}

}
