package com.own.microservice.provide.rfriends.circle.album;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
@RefreshScope // 消息总线配置
public class ProviderFriendsCircleAlbumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderFriendsCircleAlbumApplication.class, args);
    }
}
