package com.kevintam.gmall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevintam.gmall.product.entity.SkuInfo;
import com.kevintam.gmall.product.service.SkuInfoService;
import com.kevintam.gmall.product.mapper.SkuInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author kevintam
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2023-06-02 22:46:05
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{

}




