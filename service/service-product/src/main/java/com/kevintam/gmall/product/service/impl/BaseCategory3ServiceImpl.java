package com.kevintam.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevintam.gmall.common.execption.GmallException;
import com.kevintam.gmall.common.result.ResultCodeEnum;
import com.kevintam.gmall.product.entity.BaseCategory2;
import com.kevintam.gmall.product.entity.BaseCategory3;
import com.kevintam.gmall.product.service.BaseCategory3Service;
import com.kevintam.gmall.product.mapper.BaseCategory3Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author kevintam
* @description 针对表【base_category3(三级分类表)】的数据库操作Service实现
* @createDate 2023-06-02 22:46:05
*/
@Service
public class BaseCategory3ServiceImpl extends ServiceImpl<BaseCategory3Mapper, BaseCategory3>
    implements BaseCategory3Service{

    @Override
    public List<BaseCategory3> getCategory3(Long c2Id) {
        if(c2Id==null || c2Id<0){
            throw  new GmallException(ResultCodeEnum.PARAM_ERROR);
        }
        LambdaQueryWrapper<BaseCategory3> wrapper = new LambdaQueryWrapper<BaseCategory3>();
        wrapper.eq(BaseCategory3::getCategory2Id,c2Id);
        List<BaseCategory3> result = this.baseMapper.selectList(wrapper);
        return result;
    }
}




