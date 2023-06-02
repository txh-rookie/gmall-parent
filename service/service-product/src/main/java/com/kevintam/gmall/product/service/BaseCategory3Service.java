package com.kevintam.gmall.product.service;

import com.kevintam.gmall.product.entity.BaseCategory2;
import com.kevintam.gmall.product.entity.BaseCategory3;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author kevintam
* @description 针对表【base_category3(三级分类表)】的数据库操作Service
* @createDate 2023-06-02 22:46:05
*/
public interface BaseCategory3Service extends IService<BaseCategory3> {

    List<BaseCategory3> getCategory3(Long c2Id);
}
