package com.guozeyu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.guozeyu.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
