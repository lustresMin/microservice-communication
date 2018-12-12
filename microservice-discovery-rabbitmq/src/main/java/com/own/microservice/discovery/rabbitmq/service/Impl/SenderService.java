package com.own.microservice.discovery.rabbitmq.service.Impl;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mc
 * @version 1.0
 * @date 2018/12/12 17:55
 * @description 发送服务
 */
@Component
public class SenderService {
	@Resource
	private RabbitMessagingTemplate rabbitMessagingTemplate;

	public void sendFoo2Rabbitmq(final String foo) {
		this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.foo", foo);
	}

	public void sendBar2Rabbitmq(final String bar){
		this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
	}
}
