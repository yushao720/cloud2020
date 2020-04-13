package com.guozeyu.springcloud;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerLevel {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }

}
