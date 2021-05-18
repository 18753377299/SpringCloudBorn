package com.example.leave.service;

import com.example.common.ResultResponse;
import com.example.leave.dao.LeaveBasicDao;
import com.example.leave.dao.LeaveMainDao;
import com.example.leave.dao.LeaveSpecialDateDao;
import com.example.leave.po.LeaveBasic;
import com.example.leave.po.LeaveMain;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeaveService {
	
	@Autowired
    LeaveBasicDao leaveBasicDao;
	
	@Autowired
	LeaveMainDao leaveMainDao;
	
	@Autowired
	LeaveSpecialDateDao leaveSpecialDateDao;

	/**
	 * @Author: liqiankun 
	 * @Date 20190310
	 * @description  请假录入
	 * 
	 * */
	public ResultResponse saveLeaveBasic(LeaveMain leaveMain) {
		ResultResponse resultResponse =new ResultResponse();
		String jobNum = leaveMain.getJobNum();
		// 看该月考勤信息是否已经导入，若已经导入则不能进行录入该月请假信息
		if(StringUtils.isNotBlank(jobNum)) {
			
			// 通过唯一的员工工号进行查询是否能够进行该种类型的请假
			LeaveBasic leaveBasicVo = new LeaveBasic();
			leaveBasicVo.setJobNum(leaveMain.getJobNum());
			LeaveBasic leaveBasic = leaveBasicDao.selectLeaveBasicInfo(leaveBasicVo);
			// 请假的总天数
			Integer sumDay =  Integer.parseInt(String.valueOf(leaveMain.getSumDay()));
			if(sumDay>0) {
				// 年假
				if("C".equals(leaveMain.getLeaveType())) {
					//剩余年假总天数
					Integer laveDay = leaveBasic.getAnnualDay()-leaveBasic.getUsedAnnualDay();
					if(laveDay.compareTo(sumDay)<0) {
						resultResponse.setFlag("2");
						resultResponse.setMessage("剩余年假天数不足，请选择其他请假方式！");
					}else {
						
					}
				}
				// 判断该时期是否已经录入，录入的不能进行重复录入
				
				
				if("2".equals(resultResponse.getFlag())) {
				}else {
					//请假基本信息的更新
					
					// 进行请假信息的插入
					leaveMainDao.insertLeaveMainInfo(leaveMain);
				}
				
			}else {
				resultResponse.setMessage("没有进行请假，无需录入！");
				resultResponse.setFlag("2");
			}
		}
		
		
		return resultResponse;
	}
	/**
	 * @Author: liqiankun 
	 * @Date 20190311
	 * @description  请假查询
	 * 
	 * */
//	public ResultResponse selectLeaveBasic(leaveBasic);

	@ApiOperation(value="根据日期查询请假信息")
	public LeaveMain  getLeaveMainByDate(String dayCurrent){
		LeaveMain leaveMain = null;
		try {
			leaveMain = leaveMainDao.getLeaveMainByDate(dayCurrent);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("根据日期查询请假信息异常");
		}
		return leaveMain;
	}

	public  LeaveBasic queryLeaveBasicByUserCode(String userCode){
		LeaveBasic leaveBasic = null;
		try {
			leaveBasic = leaveBasicDao.queryLeaveBasicByUserCode(userCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveBasic;
	}




}
