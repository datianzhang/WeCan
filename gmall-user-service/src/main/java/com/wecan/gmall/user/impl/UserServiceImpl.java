package com.wecan.gmall.user.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.wecan.gmall.bean.UmsMember;
import com.wecan.gmall.service.UserService;
import com.wecan.gmall.user.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> users=umsMemberMapper.selectAll();
        return users;
    }
}
