package com.kevintam.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2023/6/2
 */
//主启动类
//@SpringBootApplication
//@EnableDiscoveryClient //开启服务发现
//@EnableCircuitBreaker //开启服务的熔断和降级
@SpringCloudApplication
@MapperScan("com.kevintam.gmall.product.mapper")
public class ProductMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class,args);
    }
}
