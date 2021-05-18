package com.example.leave.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
*
* 通过ins-framework-mybatis工具自动生成，表admin_specdate的VO对象<br/>
* 考勤信息表
*
*/
@Data
public class AttendanceVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 对应字段：id */
	private String id;
	/** 对应字段：dateType */
	private String userCode;
	private String username;
	/** 对应字段：部门 */
	private String department;
	/** 对应字段：人保项目代码 */
	private String projectCode;
	/** 对应字段：人保项目名称 */
	private String projectName;
	/** 对应字段：date 签到日期*/
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date signDate;
	/** 对应字段：insertTimeForHis */
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private String signTimeStart;
	/** 对应字段：operateTimeForHis */
	private String signTimeEnd;



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public String getSignTimeStart() {
		return signTimeStart;
	}
	public void setSignTimeStart(String signTimeStart) {
		this.signTimeStart = signTimeStart;
	}
	public String getSignTimeEnd() {
		return signTimeEnd;
	}
	public void setSignTimeEnd(String signTimeEnd) {
		this.signTimeEnd = signTimeEnd;
	}
	
	

}
