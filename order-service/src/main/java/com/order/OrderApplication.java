package com.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@EnableScheduling
@ComponentScan(value = {"com.order"})
public class OrderApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(OrderApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = StringUtils.isEmpty(env.getProperty("server.servlet.context-path"))
                ? "" : env.getProperty("server.servlet.context-path");
        log.info("\n" +
                "--------------------------------------------------------------\n" +
                "\tSwagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "--------------------------------------------------------------\n");
    }
}
