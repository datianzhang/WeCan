package com.wecan.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wecan.gmall.bean.PmsProductInfo;
import com.wecan.gmall.manage.utils.PmsUploadUtil;
import com.wecan.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;
    /**
     * 商品spu列表
     * @param catalog3Id
     * @return
     */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo>  spuList(String catalog3Id){
        List<PmsProductInfo> productInfos=spuService.spuList(catalog3Id);
        return productInfos;
    }

    /**
     * 保存spu商品
     * @param pmsProductInfo
     * @return
     */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public  String  saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    /**
     * 上传图片
     * @param multipartFile
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String imgUrl=PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }
}
