package com.own.microservice.discovery.rabbitmq.common;

import lombok.Getter;

@Getter
public enum QueueEnum {


    /**
     * 枚举
     */
    USER_REGISTER("provider.friends.circle.release.queue","provider.friends.circle.release"),


    ;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
