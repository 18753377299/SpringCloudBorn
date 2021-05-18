package com.example.leave.dao;

import com.example.leave.po.LeaveMain;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface LeaveMainDao {
	// 插入请假信息
	public void insertLeaveMainInfo(LeaveMain leaveMain);

	@ApiOperation(value="根据日期查询请假信息")
	public LeaveMain getLeaveMainByDate(String dayCurrent);

	@ApiOperation(value="根据机构请假主表信息")
	public List<LeaveMain> queryLeavMainAll(String userCode);


}
