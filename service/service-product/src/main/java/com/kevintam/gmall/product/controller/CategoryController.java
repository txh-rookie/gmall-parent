package com.kevintam.gmall.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kevintam.gmall.common.result.Result;
import com.kevintam.gmall.product.entity.BaseCategory1;
import com.kevintam.gmall.product.entity.BaseCategory2;
import com.kevintam.gmall.product.entity.BaseCategory3;
import com.kevintam.gmall.product.service.BaseCategory1Service;
import com.kevintam.gmall.product.service.BaseCategory2Service;
import com.kevintam.gmall.product.service.BaseCategory3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2023/6/2
 */
@RestController
@RequestMapping("/admin/product")
public class CategoryController {

    @Autowired
    private BaseCategory1Service category1Service;

    @Autowired
    private BaseCategory2Service category2Service;

    @Autowired
    private BaseCategory3Service category3Service;

    @GetMapping("/category1/all")
    public Result findAll(){
        List<BaseCategory1> result = category1Service.list();
        return Result.ok(result);
    }

    @GetMapping("/getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> category1List = category1Service.list();
        return Result.ok(category1List);
    }

    /**
     * 根据一级id分类id，查找二级id分类
     * @param categoryId
     * @return
     */
    @GetMapping("/getCategory2/{category_id}")
    public Result getCategory2(@PathVariable("category_id") Long categoryId){
//        category1Service.getById(categoryId)
//        LambdaQueryWrapper<BaseCategory2> wrapper = new LambdaQueryWrapper<>();
       List<BaseCategory2> result= category2Service.getCategory2(categoryId);
       return Result.ok(result);
    }

    @GetMapping("/getCategory3/{category_id}")
    public Result getCategory3(@PathVariable("category_id") Long c2Id){
//        category1Service.getById(categoryId)
//        LambdaQueryWrapper<BaseCategory2> wrapper = new LambdaQueryWrapper<>();
        List<BaseCategory3> result= category3Service.getCategory3(c2Id);
        return Result.ok(result);
    }
}
