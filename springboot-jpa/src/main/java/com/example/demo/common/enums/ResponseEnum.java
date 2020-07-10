package com.example.demo.common.enums;

import lombok.Getter;

/**
 * 系统响应码
 */
public enum ResponseEnum {
	//成功响应
	SUCCESS(200,"成功"),
	//失败响应
	FAIL(400,"失败" ),
	//参数为空
	NULL_PARAM(402,"参数不能为空"),
	//未登录
	LOGIN_FAIL( 403,"未登录"),
	//未授权
	UNAUTHORIZED(401,"未授权"),
	//不存在
	NOT_FOUND(404,"找不到资源"),
	// 验证码错误
	VERIFICATION_CODE_ERROR(406,"验证码错误"),
	// 验证码过期
	VERIFICATION_CODE_EXPIRED(407,"验证码过期"),
	//服务器错误
	INTERNAL_SERVER_ERROR(500,"服务器异常，请联系管理员"),
	//网络连接失败
	NET_CONNECTION_FAIL(302,"调用失败，请检查你的网络连接"),

	//令牌过期
	TOKEN_EXPIRE(503,"令牌过期"),
	//邀请用户
	INVITE_USER(600,"该用户已经被邀请");

	@Getter
	private Integer code;	
	@Getter
	private String message;
	
    ResponseEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}
}
