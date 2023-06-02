package com.kevintam.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevintam.gmall.common.execption.GmallException;
import com.kevintam.gmall.common.result.ResultCodeEnum;
import com.kevintam.gmall.product.entity.BaseCategory2;
import com.kevintam.gmall.product.service.BaseCategory2Service;
import com.kevintam.gmall.product.mapper.BaseCategory2Mapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author kevintam
* @description 针对表【base_category2(二级分类表)】的数据库操作Service实现
* @createDate 2023-06-02 22:46:05
*/
@Service
public class BaseCategory2ServiceImpl extends ServiceImpl<BaseCategory2Mapper, BaseCategory2>
    implements BaseCategory2Service{

    /**
     * select * from base_category2 where category1_id=2;
     * @param categoryId
     * @return
     */
    @Override
    public List<BaseCategory2> getCategory2(Long categoryId) {
        if(categoryId==null || categoryId<0){
            throw  new GmallException(ResultCodeEnum.PARAM_ERROR);
        }
        LambdaQueryWrapper<BaseCategory2> wrapper = new LambdaQueryWrapper<BaseCategory2>();
        wrapper.eq(BaseCategory2::getCategory1Id,categoryId);
        List<BaseCategory2> result = this.baseMapper.selectList(wrapper);
        return result;
    }
}




