package com.wecan.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wecan.gmall.bean.PmsBaseCatalog1;
import com.wecan.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.wecan.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> catalog1s=pmsBaseCatalog1Mapper.selectAll();
        return catalog1s;
    }
}
