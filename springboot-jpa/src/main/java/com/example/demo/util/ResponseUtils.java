package com.example.demo.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.enums.ResponseEnum;
import com.example.demo.common.vo.R;


import java.util.HashMap;
import java.util.Map;

/**
 * 系统响应工具类
 * @author
 */
public class ResponseUtils {

    public static R<?> info(Integer code, String message, Object data) {
        R<Object> response = new R<>()
                .setCode(code)
                .setMessage(message)
                .setData(data);
        return response;
    }

    public static R<?> success(String message,Object data) {
        R<Object> response = new R<>()
                .setCode(ResponseEnum.SUCCESS.getCode())
                .setMessage(message)
                .setData(data);
        return response;
    }

    public static R<?> success(Object data) {
        R<Object> response = new R<>()
                .setCode(ResponseEnum.SUCCESS.getCode())
                .setMessage(ResponseEnum.SUCCESS.getMessage())
                .setData(data);
        return response;
    }

    public static R<?> error(String message) {
        R<Object> response = new R<>()
                .setMessage(message)
                .setCode(ResponseEnum.FAIL.getCode());
        return response;
    }

    public static R<?> loginFail(String message) {
        R<Object> response = new R<>()
                .setMessage(message)
                .setCode(ResponseEnum.LOGIN_FAIL.getCode())
                .setData(null);
        return response;
    }

    public static R<?> unAuthorized(String message) {
        R<Object> response = new R<>()
                .setMessage(message)
                .setCode(ResponseEnum.UNAUTHORIZED.getCode());
        return response;
    }

    public static R<?> tokenExpire(String message) {
        R<Object> response = new R<>()
                .setMessage(message)
                .setCode(ResponseEnum.TOKEN_EXPIRE.getCode());
        return response;
    }


    public static R<?> error(Integer code,String message) {
        R<Object> response = new R<>()
                .setMessage(message)
                .setCode(code);
        return response;
    }

    public static R<?> success(String message, IPage<?> page){
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",page == null ? 0 : page.getTotal());
        hashMap.put("pageNo",page == null ? 1 : page.getCurrent());
        hashMap.put("pageSize",page == null ? 10 : page.getSize());
        hashMap.put("records",page == null ? 0 : page.getRecords());
        hashMap.put("pages",page == null ? 0: page.getPages());
        R<Object> response = new R<>()
                .setMessage(message)
                .setCode(ResponseEnum.SUCCESS.getCode()).
                        setData(hashMap);
        return  response;
    }
}
