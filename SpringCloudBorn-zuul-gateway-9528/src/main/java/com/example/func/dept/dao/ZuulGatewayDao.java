package com.example.func.dept.dao;

import java.util.List;

import com.example.func.dept.po.ZuulRouteVO;

public interface ZuulGatewayDao {
	
	public List<ZuulRouteVO> findByEnable(boolean enable);
}
