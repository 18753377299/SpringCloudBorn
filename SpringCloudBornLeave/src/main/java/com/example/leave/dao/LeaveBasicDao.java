package com.example.leave.dao;

import com.example.leave.po.LeaveBasic;
import io.swagger.annotations.ApiOperation;

public interface LeaveBasicDao {
	
	public LeaveBasic getLeaveBasicById(Integer id);
	
	// 查询请假基础表信息
	public LeaveBasic selectLeaveBasicInfo(LeaveBasic leaveBasic);

    @ApiOperation("根据用户机构查询请假信息")
	public LeaveBasic queryLeaveBasicByUserCode(String userCode);
}
