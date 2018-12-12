package com.own.microservice.discovery.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * @author mc
 * @version 1.0
 * @date 2018/12/12 13:57
 * @description 生产者配置
 */
@Configuration
public class ProducerConfig {
	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	Queue queueFoo(RabbitAdmin rabbitAdmin) {
		Queue queue = new Queue("queue.foo", true);
		rabbitAdmin.declareQueue(queue);
		return queue;
	}

	@Bean
	Queue queueBar(RabbitAdmin rabbitAdmin) {
		Queue queue = new Queue("queue.bar", true);
		rabbitAdmin.declareQueue(queue);
		return queue;
	}

	@Bean
	TopicExchange exchange(RabbitAdmin rabbitAdmin) {
		TopicExchange topicExchange = new TopicExchange("exchange");
		rabbitAdmin.declareExchange(topicExchange);
		return topicExchange;
	}

	@Bean
	Binding bindingExchangeFoo(Queue queueFoo, TopicExchange exchange,RabbitAdmin rabbitAdmin) {
		Binding binding = BindingBuilder.bind(queueFoo).to(exchange).with("queue.foo");
		rabbitAdmin.declareBinding(binding);
		return binding;
	}

	@Bean
	Binding bindingExchangeBar(Queue queueBar, TopicExchange exchange, RabbitAdmin rabbitAdmin) {
		Binding binding = BindingBuilder.bind(queueBar).to(exchange).with("queue.bar");
		rabbitAdmin.declareBinding(binding);
		return binding;
	}



	/**
	 * 生产者用
	 * @return
	 */
	@Bean
	public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
		RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
		rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
		rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
		return rabbitMessagingTemplate;
	}

	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		return converter;
	}
}
