package com.example.leave.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 通过ins-framework-mybatis工具自动生成，请勿手工修改。表leave_person的PO对象<br/>
 * 对应表名：leave_person
 *
 */
@Data
public class LeavePerson implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userCode;
	private String username;
	private Integer annualLeave;
	private String flag;
	private Integer departmentId;
	private String departmentName;
	private Integer teamId;
	private String teamName;
	private Date leavedate;
	private Date insertTimeForHis;
	private Date operateTimeForHis;
	private Integer isNew;

}
