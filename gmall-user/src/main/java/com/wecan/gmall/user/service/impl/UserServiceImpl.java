package com.wecan.gmall.user.service.impl;

import com.wecan.gmall.user.bean.UmsMember;
import com.wecan.gmall.user.mapper.UmsMemberMapper;
import com.wecan.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> users=umsMemberMapper.selectAllUser();
        return users;
    }
}
