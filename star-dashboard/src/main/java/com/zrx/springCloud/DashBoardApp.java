package com.zrx.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Administrator
 * @date 2022/7/8
 * @time 17:38
 */
    @SpringBootApplication
    @EnableHystrixDashboard
    public class DashBoardApp {
        public static void main(String[] args) {
            SpringApplication.run(DashBoardApp.class, args);
        }
    }

