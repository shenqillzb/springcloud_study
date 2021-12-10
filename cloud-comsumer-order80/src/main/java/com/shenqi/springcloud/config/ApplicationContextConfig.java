package com.shenqi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    /**
     * 相当于 applicationContext.xml <bean id="" class=""></bean>
     * @return
     */
    @Bean
    @LoadBalanced // 规定默认负载均衡机制
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
