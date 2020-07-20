package com.example.demo.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.user.entity.SysRole;
import com.example.demo.user.mapper.SysRoleMapper;
import com.example.demo.user.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysRoleServiceImpl  extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
