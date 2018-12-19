package com.own.microservice.discovery.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceDiscoveryGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDiscoveryGatewayApplication.class, args);
	}

	//通过方法来实现相同路由转发功能
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("path_route", r -> r.path("/about")
//						.uri("http://ityouknow.com"))
//				.build();
//	}
}

