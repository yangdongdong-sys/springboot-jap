package com.example.demo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 系统权限表
 *
 * @author yd
 * @Date 2019-09-09 15:00:54
 */
@TableName("sys_permission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysPermission implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    //主键id
    private String id;

    //权限类型：1：菜单 2：文件  3：数据权限
    private Integer permissionType;

    //权限名称
    private String permissionName;

    //权限id
    private String permissionId;

    //字典编码
    private String permissionTypeCode;

    // 菜单ID
    @TableField(exist = false)
    private String menuId;

    // 菜单父ID
    @TableField(exist = false)
    private String menuParentId;

    //children 子集
    @TableField(exist = false)
    private List<SysPermission> children = new ArrayList();
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
