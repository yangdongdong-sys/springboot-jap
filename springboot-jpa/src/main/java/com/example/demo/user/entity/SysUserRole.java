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
 * 系统用户-角色-关联表
 *
 * @author yd
 * @Date 2019-09-09 15:01:08
 */
@TableName("sys_user_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysUserRole implements Serializable {

    //主键id
    private String id;

    //用户id
    private String userId;

    //角色id
    private String roleId;

    //创建者
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //创建人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
