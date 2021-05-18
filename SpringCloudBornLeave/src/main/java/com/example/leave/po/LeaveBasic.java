package com.example.leave.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class LeaveBasic implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String jobNum;
	private String employeeName;
	private String  projectCode;
	private String  projectName;
	private String teamCode;
	private String teamName;
	private Integer annualDay;
	private Integer usedAnnualDay;
	private Integer retreatDay;
	private Integer usedRetreatDay;
	private Integer sickDay;
	private Integer usedSickDay;
	private Date insertTimeForHis;
	private Date operateTimeForHis;

}
