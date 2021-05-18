package com.example.leave.service;

import com.example.common.DateUtils;
import com.example.common.LeaveResponseVo;
import com.example.leave.dao.LeaveBasicDao;
import com.example.leave.dao.LeaveMainDao;
import com.example.leave.dao.LeaveSpecialDateDao;
import com.example.leave.po.LeaveMain;
import com.example.leave.po.LeaveSpecdate;
import com.example.leave.vo.AttendanceRequestVo;
import com.example.leave.vo.AttendanceVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class LeaveAttendanceService {
	
	@Autowired
    LeaveBasicDao leaveBasicDao;
	
	@Autowired
    LeaveMainDao leaveMainDao;
	
	@Autowired
    LeaveSpecialDateDao leaveSpecialDateDao;

	/**
	 * 根据考勤记录来判断人员倒休情况和矿工情况o
	 * ---调整请假倒休信息
	 * 20190123
	 * */
	@ApiOperation(value="进行考勤信息计算")
	public LeaveResponseVo adjustLeaveRetreatInfo(AttendanceRequestVo attendanceRequestVo) {
		LeaveResponseVo leaveResponseVo=new LeaveResponseVo();
//		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			/**获取考勤信息的年月，格式为2019-01*/
			String yearMonth = attendanceRequestVo.getYearMonth();
			/**把考勤信息整理成一个map集合，key: userCode,value: 考勤信息集合*/
			Map<String, List<AttendanceVo>> mapAttendance = this.handleAttendanceInfo(attendanceRequestVo.getAttendanceBaseData());

			/**根据日期查出所有的特殊节假日*/
			Map<String, String> specialDateMap = this.quereySpecialDate(yearMonth);
			/**根据键值即工号进行遍历*/
			for(String userCode: mapAttendance.keySet()) {
				//将签到日期和考勤数据组织成map形式
				Map<String, List<AttendanceVo>> mapAttendanceDate = this.handleAttendanceDate(mapAttendance.get(userCode));
				/**看是否离职： 如果离职将不进行考勤计算,进行下次循环*/
				if(true){
					continue;
				}
				Map<String,Object>  resultObject =  this.calculateAbsentInfo(mapAttendanceDate,specialDateMap,yearMonth,userCode);
				//根据个人的考勤信息，来进行组织个人的基础信息表和请假基础信息
				this.calculateLeaveMainBasic(userCode,resultObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Map<String,Object> calculateLeaveMainBasic(String userCode,Map<String,Object>  resultObject){
//		map.put("addAbsentDaySum",addAbsentDaySum+addHalfAbsentDaySum);
//		map.put("addrRetreatDaySum",addrRetreatDaySum);
//		map.put("absentList",absentList.addAll(halfAbsentList));
		// 查询基础表数据

		// 查询请假主表

		return null;
	}

	@ApiOperation(value="计算旷工信息，包括旷工信息、旷工天数、增加倒休天数")
	public Map<String,Object> calculateAbsentInfo(Map<String, List<AttendanceVo>> mapAttendanceDate,
												  Map<String, String> specialDateMap,String yearMonth,String userCode){
		/**查询出导入考勤信息的该月中一共有多少天*/
		int day = DateUtils.getMaxDays(yearMonth);
		Map<String,Object> map =new HashMap<>();
		/**增加旷工天数（整天和半天）和本月倒休天数*/
		double  addAbsentDaySum = 0,addHalfAbsentDaySum=0,addrRetreatDaySum = 0;
		//缺勤整天
		List<LeaveMain>   absentList = new ArrayList<>();
		// 缺勤半天
		List<LeaveMain>   halfAbsentList = new ArrayList<>();
		try {
			/**看是否已经导入考勤*/
			for(int i=1;i<day;i++) {
				/**获取当前的时间值*/
				String dayCurrent = yearMonth+"-"+(i<10?"0"+i:i);
				/**看当前值是否有考勤*/
				switch (specialDateMap.get(dayCurrent)){
					case "1":
						//工作日
						if(mapAttendanceDate.containsKey(dayCurrent)) {
							/**如果有考勤记录，看考勤记录是否正常），第一种：正常考勤，不存在迟到和早退；
							 * 第二种：上午或下午忘记打卡，打卡时间是正常时间，这样视为半天旷工，
							 * 第三种：上午（上午晚于9:00）或下午（下午晚于13:30）打卡时间迟到，或者两者都是不正常，那么计算旷工
							 * */
							String  flag = this.calculateAttendanceInfo(mapAttendanceDate,dayCurrent);
							/**查询请假信息*/
							LeaveMain leaveMain = leaveMainDao.getLeaveMainByDate(dayCurrent);
							if("0".equals(flag)){
							}else if("1".equals(flag)){
								if(null!=leaveMain){
									Double sumDay=leaveMain.getSumDay();
									if( sumDay.compareTo(Double.valueOf(0.5))<0 ){
										addHalfAbsentDaySum+=0.5;
										LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"0");
										halfAbsentList.add(LeaveMain);
									}
								}else{
									addHalfAbsentDaySum+=0.5;
									LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"0");
									halfAbsentList.add(LeaveMain);
								}
							}else if("2".equals(flag)){
								if(null!=leaveMain){
									Double sumDay=leaveMain.getSumDay();
									if( sumDay.compareTo(Double.valueOf(0.5))==0 ){
										//请假半天
										addHalfAbsentDaySum += 0.5;
										LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"0");
										halfAbsentList.add(LeaveMain);
									}else if( sumDay.compareTo(Double.valueOf(0.5))==-1 ){
										//请假天数小于0.5，则视为没有请假
										addAbsentDaySum += 1;
										LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"1");
										absentList.add(LeaveMain);
									}
								}else{
									addAbsentDaySum+=1;
									LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"1");
									absentList.add(LeaveMain);
								}

							}
						}else {
							/**如果没有考勤记录，则看有没有请假，若没有请假则记为旷工。查询请假天数，如果是整天那个不记旷工否则旷工*/
							/**查询请假信息*/
							LeaveMain leaveMain = leaveMainDao.getLeaveMainByDate(dayCurrent);
							if(null!=leaveMain){
								 // 请假总天数
								Double sumDay=leaveMain.getSumDay();
								if( sumDay.compareTo(Double.valueOf(0.5))==0 ){
									//请假半天
									addHalfAbsentDaySum += 0.5;
									LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"0");
									halfAbsentList.add(LeaveMain);
								}else if( sumDay.compareTo(Double.valueOf(0.5))==-1 ){
                                   //请假天数小于0.5，则视为没有请假
									addAbsentDaySum += 1;
									LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"1");
									absentList.add(LeaveMain);
								}else{
									/**请假天数大于0.5 ,则视为请假为整天，旷工和倒休天数增加或者减少*/
								}
							}else {
								// 没有请假，则记为旷工
								addAbsentDaySum += 1;
								LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"1");
								absentList.add(LeaveMain);
							}
						}
						break;
					case "0":
						//节假日
						if(mapAttendanceDate.containsKey(dayCurrent)) {
							/**如果有考勤记录，看考勤记录是否符合要求（符合八个小时才能算是加班）*/
							if(this.queryAttendanceVoIsTrue(mapAttendanceDate.get(dayCurrent))){
								addrRetreatDaySum +=1;
							}
						}
						break;
					case "2":
						//特殊节假日
						/**如果有考勤记录，看考勤记录是否符合要求（符合八个小时才能算是加班）*/
						if(this.queryAttendanceVoIsTrue(mapAttendanceDate.get(dayCurrent))){
							addrRetreatDaySum +=1;
						}
						break;
				}
			}
//			double  addAbsentDaySum = 0,addHalfAbsentDaySum=0,addrRetreatDaySum = 0;
			//缺勤整天 absentList\缺勤半天  halfAbsentList
            if(addrRetreatDaySum*2 >= addHalfAbsentDaySum){
            	// 本月倒休大于半天旷工情况
				addrRetreatDaySum -=  addHalfAbsentDaySum/2;
				// 删除所有的半天倒休情况列表
				halfAbsentList.removeAll(halfAbsentList);
			}else {
            	// 本月倒休小于半天旷工情况
				addHalfAbsentDaySum -=addrRetreatDaySum*2;
				for(int i=0;i<addrRetreatDaySum*2;i++){
					halfAbsentList.remove(i);
				}
			}
            // 旷工整天的情况和倒休天数相比，看剩余倒休天数是不是小数
            if (String.valueOf(addrRetreatDaySum).contains(".")){
            	//是小数，
				if(addAbsentDaySum>addrRetreatDaySum){
					/*旷工时间大于本月倒休*/
					addAbsentDaySum -=(addrRetreatDaySum+1);
					String dayCurrent = "";
					SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
					for(int i=0;i<addrRetreatDaySum;i++){
						absentList.remove(i);
						dayCurrent = sdf.format(absentList.get(i).getStartTime());
					}
					addHalfAbsentDaySum +=0.5;
					LeaveMain LeaveMain =  this.origanizeLeaveMain(userCode,dayCurrent,"0");
					halfAbsentList.add(LeaveMain);
				}else {
					addrRetreatDaySum -=addAbsentDaySum;
					for (int i=0;i<addAbsentDaySum;i++){
						absentList.remove(i);
					}
				}
			}else{
            	//不是小数
				if(addAbsentDaySum>=addrRetreatDaySum){
					//旷工时间大于或等于本月倒休
					addAbsentDaySum -=addrRetreatDaySum;
					for(int i=0;i<addrRetreatDaySum;i++){
						absentList.remove(i);
					}
				}else {
					addrRetreatDaySum -=addAbsentDaySum;
					absentList.remove(absentList);
				}
			}
			//返回旷工信息集合
			map.put("addAbsentDaySum",addAbsentDaySum+addHalfAbsentDaySum);
			map.put("addrRetreatDaySum",addrRetreatDaySum);
            map.put("absentList",absentList.addAll(halfAbsentList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="根据考勤日期查看是否添加旷工,0: 正常，1： 旷工半天，2： 整天旷工")
	public String calculateAttendanceInfo(Map<String, List<AttendanceVo>> mapAttendanceDate, String dayCurrent){
		String resultFlag = "0";
		try {
			List<AttendanceVo> attendanceVoList = mapAttendanceDate.get(dayCurrent);
			if(CollectionUtils.isNotEmpty(attendanceVoList)){
				AttendanceVo attendanceVo  = attendanceVoList.get(0);
				String signTimeStart= attendanceVo.getSignTimeStart();
				String signTimeEnd = attendanceVo.getSignTimeEnd();
				if(StringUtils.isBlank(signTimeStart)&&StringUtils.isBlank(signTimeEnd)){
					resultFlag = "2";
				}else if(StringUtils.isBlank(signTimeStart) || StringUtils.isBlank(signTimeEnd)){
					if(StringUtils.isBlank(signTimeStart)){
						// 上午忘记打卡，而下午打卡了
						int result =  DateUtils.compareTowTime(signTimeEnd,dayCurrent+"17:30:00");
						if(result>=0){
							// 打卡时间晚于17:30
							resultFlag = "1";
						}else {
							// 打卡时间早于17:30，早退
							resultFlag = "2";
						}
					}
					if (StringUtils.isBlank(signTimeStart)){
						// 下午忘记打卡，而上午打卡了
						int result =  DateUtils.compareTowTime(dayCurrent+"9:00:00",signTimeStart);
						if(result>=0){
							// 打卡时间大于上午9:00，也就是开始时间小于上午9:00
							resultFlag = "1";
						}else{
							// 打卡时间晚于上午9:00，迟到
							resultFlag = "2";
						}
					}
				}

			}else{
				resultFlag = "2";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw  new RuntimeException("根据考勤日期查看是否添加旷工"+e);
		}
		return resultFlag;
	}

	@ApiOperation(value="根据考勤日期查看是否可以增加倒休时间")
	public boolean queryAttendanceVoIsTrue(List<AttendanceVo> attendanceVoList){
		boolean result = false;
		if(CollectionUtils.isNotEmpty(attendanceVoList)){
			AttendanceVo attendanceVo = attendanceVoList.get(0);
			String signTimeStart= attendanceVo.getSignTimeStart();
			String signTimeEnd = attendanceVo.getSignTimeEnd();
			if(StringUtils.isBlank(signTimeStart) || StringUtils.isBlank(signTimeEnd)){
				result = false;
			}
			if(DateUtils.getShortHourTime(signTimeStart,signTimeEnd)>=8){
				return true;
			}
		}
		return result;
	}

	@ApiOperation(value="组织旷工信息,leaveFlag: 0(旷工半天)，1（旷工一天）")
	public LeaveMain origanizeLeaveMain(String userCode, String dayCurrent, String leaveFlag){
		LeaveMain leaveMain = new LeaveMain();
		return leaveMain;
	}

	//将考勤日期组织成map形式
	public Map<String,List<AttendanceVo>> handleAttendanceDate(List<AttendanceVo> attendanceVoList){
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, List<AttendanceVo>> mapAttendanceDate =new HashMap<String, List<AttendanceVo>>();
		if(CollectionUtils.isNotEmpty(attendanceVoList)) {
			for(AttendanceVo attendanceVo:attendanceVoList) {
				//考勤中的签到日期
				String attendanceDate = sdFormat.format(attendanceVo.getSignDate());
				if(mapAttendanceDate.containsKey(attendanceDate)) {
					mapAttendanceDate.get(attendanceDate).add(attendanceVo);
				}else {
					List<AttendanceVo> attendanceVos = new ArrayList<AttendanceVo>();
					attendanceVos.add(attendanceVo);
					mapAttendanceDate.put(attendanceDate, attendanceVos);
				}
			}
		}		
		return mapAttendanceDate;
	}
	
	@ApiOperation(value="根据日期查出所有的特殊节假日",notes="key: userCode,value: 考勤信息集合")
	public Map<String, String> quereySpecialDate(String  yearMonth){
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> map =new HashMap<String, String>();
		//根据模糊匹配查询出该年该月的所有特殊节假日的条数
		List<LeaveSpecdate>  leaveSpecdateList = leaveSpecialDateDao.querySpecialDateByTime(yearMonth);
		if(leaveSpecdateList!=null&&leaveSpecdateList.size()>0) {
			for(LeaveSpecdate leaveSpecdate: leaveSpecdateList) {
				String date = sdFormat.format(leaveSpecdate.getDate());
				map.put(date, leaveSpecdate.getDateType());
			}
		}
		return map;
	}

	@ApiOperation(value="把考勤信息整理成一个map集合中",notes="key: userCode,value: 考勤信息集合")
	public Map<String,List<AttendanceVo>> handleAttendanceInfo(List<AttendanceVo> attendanceVoList){
		Map<String, List<AttendanceVo>> mapAttendance =new HashMap<String, List<AttendanceVo>>();
		
		if(attendanceVoList!=null&&attendanceVoList.size()>0) {
			for(AttendanceVo attendanceVo:attendanceVoList) {
				if(mapAttendance.containsKey(attendanceVo.getUserCode())) {
					mapAttendance.get(attendanceVo.getUserCode()).add(attendanceVo);
				}else {
					List<AttendanceVo> attendanceVos = new ArrayList<AttendanceVo>();
					attendanceVos.add(attendanceVo);
					mapAttendance.put(attendanceVo.getUserCode(), attendanceVos);
				}
			}
		}		
		return mapAttendance;
	}

}
