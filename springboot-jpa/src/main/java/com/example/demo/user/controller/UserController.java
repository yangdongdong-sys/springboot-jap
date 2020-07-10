package com.example.demo.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.demo.common.vo.R;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import com.example.demo.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/User")
@Slf4j
public class UserController  {
    @Autowired
    private UserService  userService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据Id查询gyEssayComment
     *
     * @params id
     * @author chengxin
     */
    @Cacheable(value= "/findById")  //自动根据方法生成缓存
    @RequestMapping(value = "/findById")
    public R<?> findById(String id) {
        User user;
        try {
            user = userService.getById(id);
        } catch (Exception ex) {
            log.error("根据id查询健康咨询--文章评论信息失败!", ex);
            return ResponseUtils.error("根据id查询健康咨询--文章评论信息失败!");
        }
        return ResponseUtils.success("根据id查询健康咨询--文章评论信息成功!", user);
    }
    /**
     * 分页查询
     *
     * @params pageNo
     * @params pageSize
     * @params gyEssayComment
     * @author chengxin
     */
    @RequestMapping(value = "/findPageList")
    public R<?> findPageList(Integer pageNo, Integer pageSize, User user) {
        log.info(String.format("分页获取健康咨询--文章评论信息列表!,请求参数[pageNo=%s&pageSize=%s]", pageNo, pageSize));
        IPage<User> pageList = null;
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        try {
            LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<>(user).lambda();
            queryWrapper.orderByDesc(User::getId);
            pageList = userService.page(new Page<>(pageNo, pageSize), queryWrapper);
        } catch (Exception ex) {
            log.error("分页查询健康咨询--文章评论信息失败!", ex);
            return ResponseUtils.error("分页查询健康咨询--文章评论信息失败!");
        }
        return ResponseUtils.success("分页查询健康咨询--文章评论信息成功!", pageList);
    }
    /**
     * 新增
     *
     * @params gyEssayComment
     * @author chengxin
     */
    @PostMapping(value = "/insert")
    public R<?> insert(@RequestBody User user, HttpServletRequest request) {
        log.info("新增健康咨询--文章评论信息,请求参数 gyEssayComment={}", user);
        boolean flag;
        try {
            flag= userService.save(user);
        } catch (Exception ex) {
            log.error("新增健康咨询--文章评论信息失败!", ex);
            return ResponseUtils.error("新增健康咨询--文章评论信息失败!");
        }
        return ResponseUtils.success("新增健康咨询--文章评论信息成功!", flag);
    }
    /**
     * 更新
     *
     * @params gyHealthChannel
     * @author chengxin
     */
    @PostMapping(value = "/update")
    public R<?> update(@RequestBody User user) {
        log.info("更新健康咨询--频道信息,请求参数 gyHealthChannel={}", user);
        boolean flag;
        try {
            flag = userService.updateById(user);
        } catch (Exception ex) {
            log.error("更新健康咨询--频道信息失败!", ex);
            return ResponseUtils.error("更新健康咨询--频道信息失败!");
        }
        return ResponseUtils.success("更新健康咨询--频道信息成功!", flag);

    }
    /**
     * 批量删除
     *
     * @params ids
     * @author chengxin
     */
    @RequestMapping(value = "/remove/{ids}")
    public R<?> removeBatch(@PathVariable("ids") List<String> ids) {
        log.info("删除健康咨询--频道信息,请求参数 ids = {}", ids);
        boolean flag;
        try {
            flag = userService.removeByIds(ids);
        } catch (Exception ex) {
            log.error("删除健康咨询--频道信息失败!", ex);
            return ResponseUtils.error("删除健康咨询--频道信息失败!");
        }
        return ResponseUtils.success("删除健康咨询--频道信息成功!", flag);
    }
    /**
     * 逻辑删除
     *
     * @params ids
     * @author chengxin
     */
    @RequestMapping(value = "/logicRemove")
    public R<?> logicRemove(String id) {
        log.info("逻辑删除健康咨询--频道信息,请求参数 id=" + id);
        boolean flag;

        try {
            User user = new User().setId(id);
            flag = userService.removeById(user);
        } catch (Exception ex) {
            log.error("逻辑删除健康咨询--频道信息失败!", ex);
            return ResponseUtils.error("删除健康咨询--频道信息失败!");
        }
        return ResponseUtils.success("逻辑删除健康咨询--频道信息成功!", flag);
    }

    public void testObj() throws Exception {
        User user=new User();
        user.setUsername("Alex");
        user.setPassword("不会打篮球的程序不是好男人");

        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("502", user);
        Thread.sleep(500);
        boolean exists=redisTemplate.hasKey("502");
        if(exists){
            System.out.println(redisTemplate.opsForValue().get("502"));
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
