package com.qianfeng.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringConvert {
	
	public static String dateToString(Date date,String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(str); 
		String strDate = sdf.format(date);
		return strDate;
	}

}
