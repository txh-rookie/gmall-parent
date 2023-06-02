package com.kevintam.gmall.product.service;

import com.kevintam.gmall.product.entity.BaseCategory2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author kevintam
* @description 针对表【base_category2(二级分类表)】的数据库操作Service
* @createDate 2023-06-02 22:46:05
*/
public interface BaseCategory2Service extends IService<BaseCategory2> {

    List<BaseCategory2> getCategory2(Long categoryId);
}
