package com.example.leave.dao;

import com.example.leave.po.LeaveSpecdate;

import java.util.List;

public interface LeaveSpecialDateDao {
	
	public List<LeaveSpecdate> querySpecialDateByTime(String yearMonth);
}
