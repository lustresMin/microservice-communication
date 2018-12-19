### 基于spring cloud分布式架子
#### 层级目录说明
    microservice-communication 父级目录
        |--- microservice-common	                        公共jar
        |--- microservice-config-server	                配置服务中心
        |--- microservice-consumer-web	                消费者示例
        |--- microservice-discovery-eureka	                注册服务中心
        |--- microservice-discovery-gateway	                gateway路由网关服务
        |--- microservice-discovery-rabbitmq                消息总线服务
        |--- microservice-discovery-zuul	                zuul路由网关服务
        |--- microservice-provider-friends-circle-album	朋友圈相册服务提供
        |--- microservice-provider-friends-circle-comment	朋友圈评论服务提供
        |--- microservice-provider-friends-circle-release	朋友圈发布服务提供者
        |--- microservice-provider-friends-circle-timeline	朋友圈时间线服务提供
        
##### 2018-12-19
- 新增gateway 路由组件