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
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户表
 *
 * @author yd
 * @Date 2019-09-09 15:00:57
 */
@TableName("sys_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysUser implements Serializable {

    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    /**
     * 主键ID
     */
    private String id;

    /**
     * 工号
     */
    private String jobNo;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 性别: 1：男  2：女
     */
    private Integer sex;

    /**
     * 状态:1：正常 2 删除
     */
    private Integer status;

    /**
     * 用户头像
     */
    private String picture;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 固定电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户类型字典码
     */
    private String userTypeCode;

    /**
     * 所属部门
     */
    private String orgId;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 住址
     */
    private String address;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    @Getter
    public Integer getStatus() {
        if (status == null) {
            status = SysDictEnum.DATA_STATUS_ENABLE.getValue();
        }
        return status;
    }

    //婚姻状况
    private Integer maritalStatus;

    //婚姻状况字典码
    private String maritalStatusCode;

    //是否激活
    private Integer isActive;

    //邀请者
    private String inviteUser;

    //第三方openId
    private String openId;

    //登录次数
    private Integer loginCount;

    //是否是医生用户
    private Integer isDoctor;

    @TableField(exist = false)
    protected String createUserName;

    @TableField(exist = false)
    protected String updateUserName;

    // 是否关联角色 1关联 2不关联
    @TableField(exist = false)
    protected Integer isRelatedRole;


}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
