package com.wecan.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wecan.gmall.bean.PmsBaseCatalog1;
import com.wecan.gmall.bean.PmsBaseCatalog2;
import com.wecan.gmall.bean.PmsBaseCatalog3;
import com.wecan.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.wecan.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.wecan.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.wecan.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class CatalogServiceImpl implements CatalogService {



    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> catalog1s=pmsBaseCatalog1Mapper.selectAll();
        return catalog1s;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String calalog1Id) {
        PmsBaseCatalog2 calalog2=new PmsBaseCatalog2();
        calalog2.setCatalog1Id(calalog1Id);
        List<PmsBaseCatalog2> catalog2s=pmsBaseCatalog2Mapper.select(calalog2);
        return catalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String calalog2Id) {
        PmsBaseCatalog3 calalog3=new PmsBaseCatalog3();
        calalog3.setCatalog2Id(calalog2Id);
        List<PmsBaseCatalog3> catalog3s=pmsBaseCatalog3Mapper.select(calalog3);
        return catalog3s;
    }
}
