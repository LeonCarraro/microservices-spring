package com.leoncarraro.customerservice.configuration;

import lombok.AllArgsConstructor;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leoncarraro.amqp.configuration.AMQPConfiguration;

@Configuration
@AllArgsConstructor
public class RabbitMQConfiguration {

	private final AMQPConfiguration amqpConfiguration;

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()) //
				.to(topicExchange()) //
				.with(amqpConfiguration.getRabbitmq().getRoutingKey().getInternalNotification());
	}

	@Bean
	public Queue queue() {
		return new Queue(amqpConfiguration.getRabbitmq().getQueue().getName());
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(amqpConfiguration.getRabbitmq().getExchange().getName());
	}

}
