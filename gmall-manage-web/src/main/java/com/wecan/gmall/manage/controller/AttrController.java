package com.wecan.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wecan.gmall.bean.PmsBaseAttrInfo;
import com.wecan.gmall.bean.PmsBaseAttrValue;
import com.wecan.gmall.bean.PmsBaseSaleAttr;
import com.wecan.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;
    /**
     * 属性列表
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo>  getAttrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfoList=attrService.getAttrInfoList(catalog3Id);
        return attrInfoList;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo attrInfo){

         attrService.saveAttrInfo(attrInfo);

        return "success";
    }

    /**
     * 得到属性值列表
     * @param attrId
     * @return
     */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> attrValueList=attrService.getAttrValueList(attrId);
        return attrValueList;
    }
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> baseSaleAttrList=attrService.baseSaleAttrList();
        return baseSaleAttrList;
    }

}
