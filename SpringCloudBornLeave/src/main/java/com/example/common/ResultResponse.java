package com.example.common;

import lombok.Data;

@Data
public class ResultResponse {
	/**返回的结果*/
	private Object result;
	/**返回的标志位, 1:success,2:error*/
	private String flag;
	/**返回的信息*/
	private String message;
	
}
