package com.example.login.api;

import com.example.common.JwtUtils;
import com.example.common.ResponseResult;
import com.example.login.service.LoginService;
import com.example.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value="/login-api")
public class LoginApi {
	
	@Autowired 
	LoginService loginService;
	/**
	 * @description  用户登录
	 * @Author  liqiankun
	 * @Date 20190326 
	 * */
	@RequestMapping(value="/getInfoLogin",method= {RequestMethod.POST,RequestMethod.GET})
	public ResponseResult getInfoLogin(@RequestBody User user) {
		ResponseResult responseResult =new ResponseResult();
		Map<String,Object> map = new HashMap<String, Object>();
		//如果登录成功，则生成token数据
		boolean isSuccess = loginService.selectByUserAndPass(user.getUsername(),user.getPassword());
		
		if(isSuccess) {
			responseResult.setMessage("登陆成功！");
			responseResult.setStatusCode("1");
			/**如果登陆成功,则将获取token数据，并返回到前台*/
			String token =  this.getTokenByData(user.getUsername());
			map.put("token", token);
			responseResult.setParameterMap(map);
		}else {
			responseResult.setMessage("用户名或密码错误，请检查后重新登陆！");
			responseResult.setStatusCode("2");
		}
		
		return responseResult;
	}
	
	/**
	 * @description  生成token数据
	 * @Author  liqiankun
	 * @Date 20190326 
	 * */
	public String getTokenByData(String username) {
		
		//设置token过期时间
//		long nowData =System.currentTimeMillis();
		long maintainTime= 4*60*60*1000;
		String jwtSubject = "sxt-test-jwt";
		String jwtToken = JwtUtils.createJWT(UUID.randomUUID().toString(), jwtSubject,
				JwtUtils.generalSubject(username), maintainTime);
		
		return jwtToken;
	}
	
	
	
	
	
	
	
}
