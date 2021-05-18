package com.example.leave.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveMain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String jobNum;
	private String employeeName;
	private String teamCode;
	private String teamName;
	private String projectCode;
	private String projectName;
	private String leaveType;
	private String detailDesc;
	private Date startTime;
	private Date endTime;
	private Double sumDay;
	private String leaveFlag;
	private Date insertTimeForHis;
	private Date operateTimeForHis;
	
}
