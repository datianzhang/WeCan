package com.wecan.gmall.service;

import com.wecan.gmall.bean.PmsBaseAttrInfo;
import com.wecan.gmall.bean.PmsBaseAttrValue;
import com.wecan.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);
    String saveAttrInfo(PmsBaseAttrInfo attrInfo);

    //PmsBaseAttrValue  得到属性值列表
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
