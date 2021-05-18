package com.example.login.dao;


public interface LoginDao {
	/**
	 * 通过用户名密码来查询数据
	 * */
	public boolean selectByUserAndPass(String username, String password);
	
}
