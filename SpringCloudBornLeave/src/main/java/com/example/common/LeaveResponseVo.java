package com.example.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回给前台的结果信息
 * 状态、信息、结果
 * **/

@Data
public class LeaveResponseVo implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//返回信息状态
	private String status;
	//返回结果信息
	private String errorMessage;
	//返回的结果
	private Object result;
		
}
