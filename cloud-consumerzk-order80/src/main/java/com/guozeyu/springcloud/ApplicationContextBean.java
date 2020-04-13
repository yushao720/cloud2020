package com.guozeyu.springcloud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextBean {

    @Bean
    @LoadBalanced  //开启负载均衡机制
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
