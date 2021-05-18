package com.example.po;

import lombok.Data;

@Data
public class User {
	/**用户id*/
	private String userId;
	/**用户名*/
	private String username;
	/**用户密码*/
	private String password;
	/**用户级别*/
	private Integer level;
	
}
