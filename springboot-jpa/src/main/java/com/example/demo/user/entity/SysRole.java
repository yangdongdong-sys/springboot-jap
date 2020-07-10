package com.example.demo.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.common.enums.SysDictEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统角色表
 *
 * @author yd
 * @Date 2019-09-09 15:00:55
 */
@TableName("sys_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysRole implements Serializable {

    @TableId(value = "role_id", type = IdType.ID_WORKER_STR)
    //角色id
    private String id;

    //角色名称
    private String roleName;

    //角色英文名称
    private String roleEname;

    //角色类型:
    private Integer roleType;

    //字典编码
    private String roleTypeCode;

    //状态:1：正常 2 删除
    private Integer status;

    //是否内置角色:1 是 2：否
    private Integer isSysset;

    //所属部门
    private String orgId;

    //备注
    private String remark;

    //是否管理员角色:1 是 2：否
    private Integer isManagerRole;

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

    @TableField(exist = false)
    protected String createUserName;

    @TableField(exist = false)
    protected String updateUserName;

    @Getter
    public Integer getStatus() {
        if (status == null) {
            status = SysDictEnum.DATA_STATUS_ENABLE.getValue();
        }
        return status;
    }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
