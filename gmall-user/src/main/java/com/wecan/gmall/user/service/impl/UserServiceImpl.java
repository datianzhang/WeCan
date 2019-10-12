package com.wecan.gmall.user.service.impl;


import com.wecan.gmall.bean.UmsMember;
import com.wecan.gmall.service.UserService;
import com.wecan.gmall.user.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
