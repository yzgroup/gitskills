/*
 * @(#) egov-powerlist Tools.java Jun 16, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.cdintelligent.znzx.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: Tools.java
 * </p>
 * <p>
 * Description: 工具类
 * </p>
 * <p>
 * Copyright:Copyright(c)2014
 * </p>
 * <p>
 * Company: 成都四方
 * </p>
 * <p>
 * CreateTime:Jun 16, 2014 2:28:00 PM
 * </p>
 * 
 * @author CodingBoy
 * @version 1.0
 **/
public abstract class Tools {

	/**
	 * 判断参数是否为空，不为空返回false, 为空返回true
	 * 
	 * @author CodingBoy
	 * @param obj
	 *            判断参数
	 * @return 不为空返回false, 为空返回true
	 */
	public static boolean isNotNull(Object obj) {
		return obj != null && !"null".equals(obj) && !"".equals(obj);
	}

	public static boolean isNull(String str) {
		return str == null || "".equals(str.trim());
	}

	public static boolean isNotNull(String str) {
		return str != null && !"".equals(str.trim());
	}

	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	public static boolean isNotEmpty(Object[] array) {
		return array != null && array.length > 0;
	}

	public static boolean isEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Set<?> set) {
		if (set == null || set.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断参数是否为空，为空返回ture, 不为空返回false
	 * 
	 * @author CodingBoy
	 * @param obj
	 *            待判断参数
	 * @return 为空返回true, 不为空返回false
	 */
	public static boolean isNull(Object obj) {
		return obj == null || "null".equals(obj) || "".equals(obj);
	}

	/**
	 * 方法描述：格式化时间为字符串
	 * 
	 * @creator CodingBoy
	 * @param Type
	 * @param time
	 * @return
	 */
	public static String formatDateToStr(int type, Date time) {
		if (time == null) {
			return "";
		}
		String format = getPattern(type);
		return new SimpleDateFormat(format).format(Long.valueOf(time.getTime()));
	}

	/**
	 * 格式化字符串为时间
	 * 
	 * @param type
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date formateStrToDate(int type, String time) throws ParseException {
		if (Tools.isNull(time)) {
			return null;
		}
		String format = getPattern(type);
		return new SimpleDateFormat(format).parse(time);
	}

	public static String getPattern(int formatIndex) {
		String format = null;
		switch (formatIndex) {
		case -2:
			format = "HH:mm:ss.S";
			break;
		case -1:
			format = "yyyy-MM-dd HH:mm:ss.S";
			break;
		case 0:
			format = "yyyy-MM-dd HH:mm:ss";
			break;
		case 1:
			format = "yyyy-MM-dd 00:00:00";
			break;
		case 2:
			format = "yyyy-MM-dd 23:59:59";
			break;
		case 3:
			format = "yyyy-MM-dd";
			break;
		case 4:
			format = "yyyy-MM";
			break;
		case 5:
			format = "yyyy-MM-dd HH:mm:ss";
			break;
		case 6:
			format = "yyyy-01-01 00:00:00";
			break;
		case 7:
			format = "yyyy-12-31 23:59:59";
			break;
		case 8:
			format = "yyyy-MM-01 00:00:00";
			break;
		case 10:
			format = "yyyyMMddHHmmss";
			break;
		case 11:
			format = "yyyyMMddHHmmssS";
			break;
		case 12:
			format = "yyyy年MM月dd日";
			break;
		case 13:
			format = "yyyyMMdd-HHmmssS";
			break;
		case 14:
			format = "yyyyMMdd";
			break;
		default:
			format = "yyyy-MM-dd HH:mm:ss";
		}
		return format;
	}

	/**
	 * 创建uuid
	 * 
	 * @author CodingBoy
	 * @return
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取通用格式时间对象
	 * 
	 * @author CodingBoy
	 * @return
	 * @throws ParseException
	 */
	public static Date getCommonDate() throws ParseException {
		return Tools.formateStrToDate(0, Tools.formatDateToStr(0, new Date()));
	}

	/**
	 * 
	 * @author CodingBoy
	 * @param type
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static boolean startTimeLowerThanEndTime(int type, String startDate, String endDate) throws ParseException {
		Date startD = Tools.formateStrToDate(type, startDate);
		Date endD = Tools.formateStrToDate(type, endDate);
		if (startD.getTime() > endD.getTime()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: deepcopy
	 * @Description: list进行克隆
	 * @param src
	 *            源
	 * @return 克隆实体
	 * @throws IOException
	 *             IOException
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException
	 */
	public static List deepcopy(List src) throws IOException, ClassNotFoundException {

		ByteArrayOutputStream byteout = new ByteArrayOutputStream();

		ObjectOutputStream out = new ObjectOutputStream(byteout);

		out.writeObject(src);

		ByteArrayInputStream bytein = new ByteArrayInputStream(byteout.toByteArray());

		ObjectInputStream in = new ObjectInputStream(bytein);

		List dest = (List) in.readObject();

		return dest;

	}

	/**
	 * 判断字符串数组中是否包含某字符串元素
	 *
	 * @param substring
	 *            某字符串
	 * @param source
	 *            源字符串数组
	 * @return 包含则返回true，否则返回false
	 */
	public static boolean isIn(String substring, String[] source) {
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}
	
	 /**
     * 获取去除字符串中所有空格
     * @author Michael
     * @param assignStr
     * @return String
     */
	public static String getStringNoBlank(String assignStr) {      
        if(assignStr!=null && !"".equals(assignStr)) {      
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");      
            Matcher m = p.matcher(assignStr);      
            String strNoBlank = m.replaceAll("");      
            return strNoBlank;      
        }else {      
            return assignStr;      
        }           
    }
}
