package com.kevintam.gmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2023/6/2
 */
@SpringCloudApplication
public class GatewayMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class,args);
    }
}
