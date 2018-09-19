package com.own.microservice.discovery.rabbitmq.common;

import lombok.Getter;

@Getter
public enum ExchangeEnum {
    /**
     * 交换配置枚举
     */
    USER_REGISTER("provider.friends.circle.release.topic.exchange"),
    ;
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
