package com.example.demo.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统角色-权限-关联表
 *
 * @author yd
 * @Date 2019-09-09 15:00:55
 */
@TableName("sys_role_permission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysRolePermission implements Serializable {
    //主键
    private String id;

    //角色id
    private String roleId;

    //权限id
    private String permissionId;

    //创建者
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //更新者
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
