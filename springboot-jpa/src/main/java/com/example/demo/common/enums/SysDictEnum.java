package com.example.demo.common.enums;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * 字典枚举表
 *
 * @author yd
 */
public enum SysDictEnum {

    LOGIN_TYPE_WX("登录类型", "微信", "LOGIN_TYPE", 3),
    LOGIN_TYPE_PHONE("登录类型", "手机号", "LOGIN_TYPE", 2),
    LOGIN_TYPE_PWD("登录类型", "密码", "LOGIN_TYPE", 1),

    DATA_STATUS_ENABLE("数据状态", "正常", "DATA_STATUS", 1),
    DATA_STATUS_DISABLE("数据状态", "删除", "DATA_STATUS", 2),

    MENU_TYPE_MENU("菜单类型", "菜单", "MENU_TYPE", 1),
    MENU_TYPE_BUTTON("菜单类型", "按钮", "MENU_TYPE", 2),

    USER_TYPE_APP("用户类型", "APP用户", "USER_TYPE", 1),
    USER_TYPE_WEB("用户类型", "WEB管理员", "USER_TYPE", 2),
    USER_TYPE_MANAGER("用户类型", "系统管理员", "USER_TYPE", 3),

    USER_SEX_MAN("性别", "男", "SEX", 1),
    USER_SEX_WOMAN("性别", "女", "SEX", 2),

    /**
     * 婚姻状态
     */
    MARRIED("婚姻状态", "已婚", "MARITAL_STATUS", 1),
    UNMARRIED("婚姻状态", "未婚", "MARITAL_STATUS", 2),



    /**
     * 文件类型
     */
    TEXT("文件类型", "Text", "FILE_TYPE", 1),
    EXCEL("文件类型", "Excel", "FILE_TYPE", 2),
    WORD("文件类型", "Word", "FILE_TYPE", 3),
    PDF("文件类型", "PDF", "FILE_TYPE", 4),
    ZIP("文件类型", "ZIP", "FILE_TYPE", 5),
    IMAGE("文件类型", "IMAGE", "FILE_TYPE", 6),
    VIDEO("文件类型", "VIDEO", "FILE_TYPE", 7),




    /**
     * 权限类型
     */
    PERMISSION_MENU("权限类型", "菜单", "PERMISSION_TYPE", 1),
    PERMISSION_FILE("权限类型", "文件", "PERMISSION_TYPE", 2),
    PERMISSION_DATA("权限类型", "数据", "PERMISSION_TYPE", 3),



    /**
     * 角色类型 超级管理员 系统管理员 普通用户
     */
    ROLE_ADMIN("角色类型", "超级管理员", "ROLE_TYPE", 1),
    ROLE_SYS("角色类型", "系统管理员", "ROLE_TYPE", 2),
    ROLE_GENERAL_USER("角色类型", "普通用户", "ROLE_TYPE", 3),

    /**
     * 是否显示(1、显示；2、隐藏)
     */
    SHOW_YES("是否显示", "显示", "IS_SHOW", 1),
    SHOW_NO("是否显示", "隐藏", "IS_SHOW", 2),

    /**
     * 是否显示(1、显示；2、隐藏)
     */
    IS_YES("是否关联规格", "是", "IS_RELATION_SPECS", 1),
    IS__NO("是否关联规格", "否", "IS_RELATION_SPECS", 2),

    /**
     * 是否
     */
    YES("是否", "是", "YES_OR_NO", 1),
    NO("是否", "否", "YES_OR_NO", 2),


    /**
     *  日志类型
     */
    LOG_TYPE_LOGIN("日志类型", "登录", "LOG_TYPE", 1),
    LOG_TYPE_OPERATION("日志类型", "操作", "LOG_TYPE", 2),
    LOG_TYPE_SYSTEM("日志类型", "系统", "LOG_TYPE", 3),
;
    @Getter
    private String title;

    @Getter
    private String name;

    @Getter
    private String code;

    @Getter
    private Integer value;

    SysDictEnum(String title, String name, String code, Integer value) {
        this.title = title;
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public static List<SysDictEnum> getEnumList(String code) {
        List<SysDictEnum> list = Lists.newArrayList();
        for (SysDictEnum type : SysDictEnum.values()) {
            if (type.getCode().equals(code)) {
                list.add(type);
            }
        }
        return list;
    }

    public static String getLabel(String code, String value) {
        List<SysDictEnum> enumList = getEnumList(code);
        String valueLabel = "";
        for (SysDictEnum sysDictEnum : enumList) {
            if (sysDictEnum.getValue().equals(Integer.valueOf(value))) {
                valueLabel = sysDictEnum.getName();
                break;
            }
        }
        return valueLabel;
    }
}
