package com.example.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.common.mapper.RootMapper;
import com.example.demo.user.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole>, RootMapper<SysRole> {

}
