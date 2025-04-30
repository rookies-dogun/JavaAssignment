package com.rookies3.myspringbootlab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class DevConfig {


    @Bean
    public MyEnvironment myEnvironment() {
        return new MyEnvironment("운영환경");
    }
}
