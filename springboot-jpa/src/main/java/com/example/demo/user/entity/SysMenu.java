package com.example.demo.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.common.enums.SysDictEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 系统菜单表
 *
 * @author yd
 * @Date 2019-09-09 15:00:52
 */
@TableName("sys_menu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysMenu implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    //菜单id
    private String id;

    //父ID
    private String parentId;

    //父id 组
    private String parentIds;

    @JsonProperty("name")
    //菜单名称
    private String menuName;

    //菜单英文名称
    private String menuEname;

    //前端路由地址
    private String path;

    //请求地址
    private String url;

    //排序
    private Integer sort;

    //状态:1：正常 2 删除
    private Integer status;

    //字典编码
    private String menuTypeCode;

    //菜单类型
    private Integer menuType;

    //图标
    private String icon;

    //是否显示 1：是 2:否
    private Integer isShow;

    //权限码
    private String permission;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //树级
    private Integer level;

    //叶子节点
    private Integer isLeaf;

    //备注
    private String remark;


    //children 子集
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<SysMenu>();

    @Getter
    public Integer getStatus() {
        if (status == null) {
            status = SysDictEnum.DATA_STATUS_ENABLE.getValue();
        }
        return status;
    }


}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
