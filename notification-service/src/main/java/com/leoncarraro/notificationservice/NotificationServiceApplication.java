package com.leoncarraro.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { //
		"com.leoncarraro.notificationservice", //
		"com.leoncarraro.amqp" //
})
@EnableEurekaClient
public class NotificationServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}
