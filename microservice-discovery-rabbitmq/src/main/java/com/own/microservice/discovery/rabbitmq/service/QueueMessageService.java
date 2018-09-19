package com.own.microservice.discovery.rabbitmq.service;

import com.own.microservice.discovery.rabbitmq.common.ExchangeEnum;
import com.own.microservice.discovery.rabbitmq.common.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * @description:    消息队列业务
 * @author:         mc
 * @createDate:     2018/7/19 15:08
 * @version:        1.0
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback {
    /**
     * 发送消息到rabbitmq消息队列
     * @param message 消息内容
     * @param exchangeEnum 交换配置枚举
     * @param queueEnum 队列配置枚举
     * @throws Exception
     */
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception;


}
