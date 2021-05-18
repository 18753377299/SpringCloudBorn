package com.example.leave.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttendanceRequestVo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**月份类型： 2020-12*/
	private String yearMonth;
	/**数量*/
	private String count;
	/**传递的参数类型*/
	private List<AttendanceVo> attendanceBaseData;


	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<AttendanceVo> getAttendanceBaseData() {
		return attendanceBaseData;
	}
	public void setAttendanceBaseData(List<AttendanceVo> attendanceBaseData) {
		this.attendanceBaseData = attendanceBaseData;
	}
	
	
}
