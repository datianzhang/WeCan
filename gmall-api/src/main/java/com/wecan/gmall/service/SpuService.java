package com.wecan.gmall.service;

import com.wecan.gmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {

    String  saveSpuInfo(PmsProductInfo pmsProductInfo);
    List<PmsProductInfo> spuList(String catalog3Id);

}
