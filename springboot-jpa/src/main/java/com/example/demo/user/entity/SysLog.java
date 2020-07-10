package com.example.demo.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Map;

/**
 * @author
 */
@TableName("sys_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysLog  {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     *  标题
     */
    private String name;

    /**
     *  类名
     */
    private String clazz;

    /**
     *  方法
     */
    private String method;

    /**
     *  请求地址
     */
    private String requestUrl;

    /**
     *  请求参数
     */
    private String requestParams;

    /**
     *  消息
     */
    private String msg;

    /**
     *  ip地址
     */
    private String ipaddr;

    /**
     *  用户代理
     */
    private String userAgent;

    /**
     *  日志类型
     */
    private String logType;

    /**
     *  日志Code码
     */
    private String logTypeCode;


    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     *  客户端类型
     */
    private Integer clientType;

    /**
     *  设备信息
     */
    private String deviceInfo;

    /**
     *  花费时长
     */
    private Integer costTime;

    /**
     * 转换请求参数为Json
     *
     * @param paramMap
     */
    public void setMapToParams(Map<String, String[]> paramMap) {

        this.requestParams = ObjectUtil.mapToString(paramMap);
    }

}
