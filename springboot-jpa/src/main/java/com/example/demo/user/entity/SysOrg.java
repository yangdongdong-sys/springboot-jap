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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 系统机构表
 *
 * @author yd
 * @Date 2019-09-09 15:00:53
 */
@TableName("sys_org")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysOrg implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    //部门id
    private String id;

    //父id
    private String parentId;

    //父ids组
    private String parentIds;

    //机构名称
    private String orgName;

    //部门名称简写
    private String orgShortName;

    //机构编码
    private String orgCode;

    //机构类型
    private Integer orgType;

    //字典编码
    private String orgTypeCode;

    //排序
    private Integer sort;

    //区域id
    private String areaId;

    //省id
    private String provinceId;

    //市id
    private String cityId;

    //县/区id
    private String countyId;

    //联系人
    private String contact;

    //电话
    private String phone;

    //地址
    private String address;

    //机构等级
    private Integer orgGrade;

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

    //状态:1：正常 2 删除
    private Integer status;

    //树级
    private Integer level;

    //是否叶子节点 1：是  0 否
    private Integer isLeaf;

    //备注
    private String remark;


    //children 子集
    @TableField(exist = false)
    private List<SysOrg> children = new ArrayList<SysOrg>();

    @Getter
    public Integer getStatus() {
        if (status == null) {
            status = SysDictEnum.DATA_STATUS_ENABLE.getValue();
        }
        return status;
    }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
