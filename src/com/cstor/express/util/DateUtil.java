/**
 * Project Name:Translate
 * File Name:DateUtil.java
 * Package Name:com.cstor.translate.util
 * Date:2016年10月17日下午2:29:04
 * Copyright (c) 2016, douyoubin@cstor.com All Rights Reserved.
 *
*/

package com.cstor.express.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName:DateUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月17日 下午2:29:04 <br/>
 * @author   douyoubin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class DateUtil {
	
	public static final SimpleDateFormat SIMPLE_DATE = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat FULL_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getSimpleDate(Date date){
		return date==null?"":SIMPLE_DATE.format(date);
	}
	
	public static int compareDateVsNow(Date date){
		
		if(date==null){
			return -1;
		}
		
		Date now = new Date();
		Calendar nowCal = Calendar.getInstance();
		nowCal.setTime(now);
		
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		
		System.out.println(nowCal.get(Calendar.YEAR));
		System.out.println(dateCal.get(Calendar.YEAR));
		System.out.println(nowCal.get(Calendar.MONTH));
		System.out.println(dateCal.get(Calendar.MONTH));
		System.out.println(nowCal.get(Calendar.DAY_OF_MONTH));
		System.out.println(dateCal.get(Calendar.DAY_OF_MONTH));
		
		if(nowCal.get(Calendar.YEAR) > dateCal.get(Calendar.YEAR)){ // 年份比现在早
			return -1;
		} else if(nowCal.get(Calendar.YEAR) < dateCal.get(Calendar.YEAR)){ //年份比现在大
			return  1;
		}else if(nowCal.get(Calendar.MONTH) > dateCal.get(Calendar.MONTH)){  //年份相等 月份比现在早
			return -1;
		}else if(nowCal.get(Calendar.MONTH) < dateCal.get(Calendar.MONTH)){//年份相等 月份比现在晚
			return 1;
		}else if(nowCal.get(Calendar.DAY_OF_MONTH)>dateCal.get(Calendar.DAY_OF_MONTH)){ //年月相同，日期比现在早
			return -1;
		}else if(nowCal.get(Calendar.DAY_OF_MONTH) <= dateCal.get(Calendar.DAY_OF_MONTH)){
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws ParseException {
		//System.out.println(DateUtil.compareDateVsNow(FULL_DATE_TIME.parse("2016-10-16 15:12:22")));
	}
}

