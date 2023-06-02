package com.kevintam.gmall.product.controller;

import com.kevintam.gmall.common.result.Result;
import com.kevintam.gmall.product.entity.BaseAttrInfo;
import com.kevintam.gmall.product.service.BaseAttrInfoService;
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
 * @createDate 2023/6/3
 */
@RestController
@RequestMapping("/admin/product")
public class AttrInfoController {
    @Autowired
    private BaseAttrInfoService attrInfoService;


    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result getAttrInfo(@PathVariable("category1Id") Long c1Id,
                              @PathVariable("category2Id") Long c2Id,
                              @PathVariable("category3Id") Long c3Id) {
        List<BaseAttrInfo> result = attrInfoService.getAttrInfo(c1Id, c2Id, c3Id);
        return Result.ok(result);
    }

}
