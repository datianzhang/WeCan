package com.wecan.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wecan.gmall.bean.UmsMember;

import com.wecan.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户类
 */
@Controller
public class UserController {

    @Reference
    UserService userService;
    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello world!";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> users=userService.getAllUser();
        return users;
    }


}
