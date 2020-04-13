package com.guozeyu.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/configinfo")
    public String getConfigInfo() {
        return configInfo;
    }


}
