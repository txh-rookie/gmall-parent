package com.kevintam.gmall.product.controller;

import com.kevintam.gmall.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2023/6/2
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Result hello(){
        return Result.ok();
    }
}
