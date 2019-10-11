package com.wecan.gmall.user.mapper;

import com.wecan.gmall.user.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsMemberMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();
}
