package com.wecan.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wecan.gmall.bean.PmsProductImage;
import com.wecan.gmall.bean.PmsProductInfo;
import com.wecan.gmall.bean.PmsProductSaleAttr;
import com.wecan.gmall.bean.PmsProductSaleAttrValue;
import com.wecan.gmall.manage.mapper.PmsProductImageMapper;
import com.wecan.gmall.manage.mapper.PmsProductInfoMapper;
import com.wecan.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.wecan.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.wecan.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired //商品属性信息
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired //商品属性值信息
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Autowired //商品图片信息
    PmsProductImageMapper pmsProductImageMapper;

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //保存商品信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);
        String productId=pmsProductInfo.getId(); //商品信息主键
        //保存商品图片信息
        List<PmsProductImage> productImageList=pmsProductInfo.getSpuImageList();
        for (PmsProductImage productImage:productImageList){
            productImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(productImage);
        }
        //保存商品属性信息
        List<PmsProductSaleAttr> productSaleAttrList=pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr productSaleAttr:productSaleAttrList){
            productSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(productSaleAttr);
            //保存商品属性值信息
            List<PmsProductSaleAttrValue> productSaleAttrValueList=productSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue productSaleAttrValue:productSaleAttrValueList){
                productSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(productSaleAttrValue);
            }
        }
        return "success";
    }

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo product=new PmsProductInfo();
        product.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> productInfos=pmsProductInfoMapper.select(product);
        return productInfos;
    }
}
