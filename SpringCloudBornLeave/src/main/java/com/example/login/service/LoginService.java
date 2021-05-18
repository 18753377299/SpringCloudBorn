package com.example.login.service;

import com.example.login.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
    LoginDao loginDao;
	
	public boolean selectByUserAndPass(String username,String password) {
		boolean isSuccess = loginDao.selectByUserAndPass(username, password);
		return isSuccess;
	}
	
}
