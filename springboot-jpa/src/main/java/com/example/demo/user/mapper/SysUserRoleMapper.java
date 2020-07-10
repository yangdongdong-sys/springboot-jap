package com.example.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.common.mapper.RootMapper;
import com.example.demo.user.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole>, RootMapper<SysUserRole> {
}
