package com.wecan.gmall.service;

import com.wecan.gmall.bean.PmsBaseCatalog1;
import com.wecan.gmall.bean.PmsBaseCatalog2;
import com.wecan.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();
    List<PmsBaseCatalog2> getCatalog2(String calalog1Id);
    List<PmsBaseCatalog3> getCatalog3(String calalog2Id);
}
