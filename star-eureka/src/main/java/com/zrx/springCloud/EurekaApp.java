package com.zrx.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @date 2022/7/5
 * @time 22:24
 */
@SpringBootApplication
@EnableEurekaServer      // 在当前的Spring Boot服务中启用Eureka服务器。
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}