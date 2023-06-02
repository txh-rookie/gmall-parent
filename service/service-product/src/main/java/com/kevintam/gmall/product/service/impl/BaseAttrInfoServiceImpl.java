package com.kevintam.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevintam.gmall.product.entity.BaseAttrInfo;
import com.kevintam.gmall.product.entity.BaseAttrValue;
import com.kevintam.gmall.product.service.BaseAttrInfoService;
import com.kevintam.gmall.product.mapper.BaseAttrInfoMapper;
import com.kevintam.gmall.product.service.BaseAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author kevintam
* @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
* @createDate 2023-06-02 22:46:05
*/
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo>
    implements BaseAttrInfoService{

    @Autowired
    private BaseAttrValueService attrValueService;
    /**
     * 根据三级id查询平台属性
     * @param c1Id
     * @param c2Id
     * @param c3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrInfo(Long c1Id, Long c2Id, Long c3Id) {
        //sql语句 select * from base_attr_info <where> <if test="c1Id!=null || c1Id !=0"> c1Id=#{c1id} </if> ...
        LambdaQueryWrapper<BaseAttrInfo> wrapper = new LambdaQueryWrapper<>();
        //查询一级分类
        if(c1Id!=null && c1Id>0 ){
            wrapper.eq(BaseAttrInfo::getCategoryId,c1Id).and(attr->{
                attr.eq(BaseAttrInfo::getCategoryLevel,1);
            });
        }
        if(c2Id!=null && c2Id>0){
            wrapper.or(attr->{
                attr.eq(BaseAttrInfo::getCategoryId,c2Id).and(attrInfo->{
                   attrInfo.eq(BaseAttrInfo::getCategoryLevel,2);
                });
            });
        }
        if(c3Id!=null && c3Id>0){
            wrapper.or(attr->{
                attr.eq(BaseAttrInfo::getCategoryId,c3Id).and(attrInfo->{
                    attrInfo.eq(BaseAttrInfo::getCategoryLevel,3);
                });
            });
        }
        //根据分类id查询所有的平台属性
        List<BaseAttrInfo> attrInfos = this.baseMapper.selectList(wrapper);
        //根据我们的attrInfo查询对应的平台属性
        if(attrInfos!=null && attrInfos.size()>0){
            attrInfos.forEach(attrInfo->{
                Long attrId = attrInfo.getId();
                List<BaseAttrValue> attrValueResult = attrValueService.list(new LambdaQueryWrapper<BaseAttrValue>().eq(BaseAttrValue::getAttrId, attrId));
                attrInfo.setAttrValueList(attrValueResult);
            });
        }

        return attrInfos;
    }
}




