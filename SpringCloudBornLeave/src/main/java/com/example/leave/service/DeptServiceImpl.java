package com.example.leave.service;

import com.example.leave.dao.DeptDao;
import com.example.leave.dao.LeaveBasicDao;
import com.example.leave.po.Dept;
import com.example.leave.po.LeaveBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl{	
	
	@Autowired
	private DeptDao dao;
	
	@Autowired
	private LeaveBasicDao leaveBasicDao;
	
	public Dept get(Long id){
		return dao.findById(id);
	}
	
	public LeaveBasic getLeaveBasic(Integer id) {
		return leaveBasicDao.getLeaveBasicById(id);
	}
	
}
