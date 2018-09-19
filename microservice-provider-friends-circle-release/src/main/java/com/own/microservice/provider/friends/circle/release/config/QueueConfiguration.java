package com.own.microservice.provider.friends.circle.release.config;

import com.own.microservice.discovery.rabbitmq.common.ExchangeEnum;
import com.own.microservice.discovery.rabbitmq.common.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @description:    消息队列配置
 * @author:         mc
 * @createDate:     2018/7/19 15:48
 * @version:        1.0
 */
@Configuration
public class QueueConfiguration {
    /**
     * 路由交换实例对象
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(ExchangeEnum.USER_REGISTER.getValue());
    }

    /**
     * 配置队列对象实例,并设置持久化队列
     * @return
     */
    @Bean
    public Queue userRegisterQueue(){
        return new Queue(QueueEnum.USER_REGISTER.getName(),true);
    }

    /**
     * 将队列绑定到路由交换配置上并设置指定路由键进行转发
     * @return
     */
    @Bean
    public Binding userRegisterBinding(){
        return BindingBuilder.bind(userRegisterQueue()).to(directExchange()).with(QueueEnum.USER_REGISTER.getRoutingKey());
    }
}
