package com.own.microservice.provider.friends.circle.release;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class ProviderFriendsCircleReleaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderFriendsCircleReleaseApplication.class, args);
    }
}
