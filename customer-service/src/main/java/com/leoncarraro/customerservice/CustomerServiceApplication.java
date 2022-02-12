package com.leoncarraro.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { //
		"com.leoncarraro.customerservice", //
		"com.leoncarraro.amqp" //
})
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.leoncarraro.clientsopenfeign.clients")
public class CustomerServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
