package com.example.demo.user.controller;

import com.example.demo.common.vo.R;
import com.example.demo.user.entity.SysUser;
import com.example.demo.user.service.SysUserService;
import com.example.demo.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Sysuser")
@Slf4j
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据Id查询用户
     *
     * @params id
     * @author yd
     */
    @Cacheable(value= "/findById")  //自动根据方法生成缓存
    @RequestMapping(value = "/findById")
    public R<?> findById(String id) {
        SysUser Sysuser;
        try {
            Sysuser = sysUserService.getById(id);
        } catch (Exception ex) {
            log.error("根据id查询系统用户--个人信息失败!", ex);
            return ResponseUtils.error("根据id查询系统用户--个人信息失败!");
        }
        return ResponseUtils.success("根据id查询系统用户--个人信息成功!", Sysuser);
    }
    /**
     * 新增
     *
     * @params Sysuser
     * @author yd
     */
    @PostMapping(value = "/insert")
    public R<?> insert(@RequestBody SysUser Sysuser, HttpServletRequest request) {
        log.info("新增系统用户--个人信息,请求参数 Sysuser={}", Sysuser);
        boolean flag;
        try {
            flag= sysUserService.save(Sysuser);
        } catch (Exception ex) {
            log.error("新增系统用户--个人信息失败!", ex);
            return ResponseUtils.error("新增系统用户--个人信息失败!");
        }
        return ResponseUtils.success("新增系统用户--个人信息成功!", flag);
    }
}
