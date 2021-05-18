package com.example.common;

import io.swagger.annotations.ApiOperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    /**
	 * 获取当月最大天数
	 * @param year 年份
	 * @param month 月份
	 * @return int 最大天数
	 */
    public static int getDaysByYearMonth(int year, int month) {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }
	@ApiOperation(value="通过当前日期获取该月最大的天数")
	public static int getMaxDays(String yearMonth) {
		int day = 0;
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdFormat.parse(yearMonth));
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			day = DateUtils.getDaysByYearMonth(year, month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}
	@ApiOperation(value="获取两个日期相差小时数")
	public static long getShortHourTime(String signTimeStart,String signTimeEnd) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
		long hour = 0;
		try {
			long  startTime = df.parse(signTimeStart).getTime();
			long  endTime = df.parse(signTimeEnd).getTime();
			hour = (endTime-startTime)/(1000*60*60);
		} catch (ParseException e) {
			e.printStackTrace();
			throw  new RuntimeException("日期转换格式异常");
		}
		return hour;
	}
	@ApiOperation(value="比较两个日期的大小")
	public static int compareTowTime(String signTimeStart,String signTimeEnd) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int  result = 0;
		try {
			Date  startTime = df.parse(signTimeStart);
			Date  endTime = df.parse(signTimeEnd);
			result = startTime.compareTo(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
			throw  new RuntimeException("日期转换格式异常");
		}
		return result;
	}

    
    /**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param date
	 * @return 当前日期是星期几
	 */
	public static int getWeekOfDate(Date date) {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	/**
	 * 获得某个月最大天数
	 * @param year 年份
	 * @param month 月份 (1-12)
	 * @return 某个月最大天数
	 */
	public int getMaxDayByYearMonth(int year, int month) {
	  Calendar calendar = Calendar.getInstance();
	  calendar.set(Calendar.YEAR, year);
	  calendar.set(Calendar.MONTH, month);
	  return calendar.getActualMaximum(Calendar.DATE);
	}	
	/**
	 * map降序排序
	 * @param map
	 * @return 排序后的map
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
