package com.rookies3.myspringbootlab.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class MyPropRunner implements ApplicationRunner {

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Value("${myprop.username}")
    private String username;

    @Value("${myprop.port}")
    private int port;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("[debug] myprop.username = {}", username);
        logger.debug("[debug] myprop.port = {}", port);
        logger.info("[info] myprop.username = {}", username);
        logger.info("[info] myprop.port = {}", port);
    }
}
