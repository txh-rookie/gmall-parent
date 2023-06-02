package com.kevintam.gmall.product.service;

import com.kevintam.gmall.product.entity.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author kevintam
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2023-06-02 22:46:05
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    List<BaseAttrInfo> getAttrInfo(Long c1Id, Long c2Id, Long c3Id);
}
