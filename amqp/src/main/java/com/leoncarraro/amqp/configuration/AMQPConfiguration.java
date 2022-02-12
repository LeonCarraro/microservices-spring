package com.leoncarraro.amqp.configuration;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.amqp")
public class AMQPConfiguration {

	private final Rabbitmq rabbitmq = new Rabbitmq();

	@Getter
	@Setter
	public static class Rabbitmq {

		private final Exchange exchange = new Exchange();

		private final Queue queue = new Queue();

		private final RoutingKey routingKey = new RoutingKey();

	}

	@Getter
	@Setter
	public static class Exchange {

		private String name;

	}

	@Getter
	@Setter
	public static class Queue {

		private String name;

	}

	@Getter
	@Setter
	public static class RoutingKey {

		private String internalNotification;

	}

}
