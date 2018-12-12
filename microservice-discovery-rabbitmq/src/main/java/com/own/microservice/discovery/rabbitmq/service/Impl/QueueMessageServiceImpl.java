package com.own.microservice.discovery.rabbitmq.service.Impl;

import com.own.microservice.discovery.rabbitmq.common.ExchangeEnum;
import com.own.microservice.discovery.rabbitmq.common.QueueEnum;
import com.own.microservice.discovery.rabbitmq.service.queueMessageService;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Administrator
 */
@Component
public class QueueMessageServiceImpl implements queueMessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private RabbitMessagingTemplate rabbitMessagingTemplate;


    @Override
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum){
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息到消息队列
        rabbitTemplate.convertAndSend(exchangeEnum.getValue(),queueEnum.getRoutingKey(),message,correlationId);
    }

    /**
     * 消息回调确认方法
     * @param correlationData   请求数据对象
     * @param b 是否发送成功
     * @param s b为false时，显示的原因cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(" 回调id:" + correlationData.getId());
        if (b) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败:" + s);
        }
    }
}
