package com.wecan.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wecan.gmall.bean.PmsBaseAttrInfo;
import com.wecan.gmall.bean.PmsBaseAttrValue;
import com.wecan.gmall.bean.PmsBaseSaleAttr;
import com.wecan.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.wecan.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.wecan.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.wecan.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id) {
        PmsBaseAttrInfo attrInfo=new PmsBaseAttrInfo();
        attrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfoList=pmsBaseAttrInfoMapper.select(attrInfo);
        return attrInfoList;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo attrInfo) {
        //保存屬性
        pmsBaseAttrInfoMapper.insertSelective(attrInfo);
        //屬性值
        List<PmsBaseAttrValue> attrValues=attrInfo.getAttrValueList();
        for(PmsBaseAttrValue pmsBaseAttrValue:attrValues){
            pmsBaseAttrValue.setAttrId(attrInfo.getId());
            pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
        }
        return "success";
    }


    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue attrValue=new PmsBaseAttrValue();
        attrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> attrValueList=pmsBaseAttrValueMapper.select(attrValue);
        return attrValueList;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> baseSaleAttrs=pmsBaseSaleAttrMapper.selectAll();
        return baseSaleAttrs;
    }
}
