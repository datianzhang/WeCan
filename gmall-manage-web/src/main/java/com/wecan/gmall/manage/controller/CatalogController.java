package com.wecan.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wecan.gmall.bean.PmsBaseCatalog1;
import com.wecan.gmall.bean.PmsBaseCatalog2;
import com.wecan.gmall.bean.PmsBaseCatalog3;
import com.wecan.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class CatalogController {

    @Reference
    CatalogService catalogService;

    /**
     * 获取catalog1集合
     * @return catalog1
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1=catalogService.getCatalog1();
        return catalog1;
    }
    /**
     * 获取catalog2集合
     * @return catalog2
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2=catalogService.getCatalog2(catalog1Id);
        return catalog2;
    }

    /**
     * 获取catalog3集合
     * @return catalog3
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3=catalogService.getCatalog3(catalog2Id);
        return catalog3;
    }
}
