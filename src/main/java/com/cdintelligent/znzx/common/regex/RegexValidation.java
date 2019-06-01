package com.cdintelligent.znzx.common.regex;

import java.util.regex.Pattern;

/**
 * 
 * @author Michael
 *
 * 2017年11月9日
 *
 */
public class RegexValidation {
	
	
	/**
	 * 简单的18位  统一社会信用代码验证
	 */
	public static final String UNIONCREDITNO_REGEX = "^(91|92|93|95|99)[0-9a-zA-Z]{16}$";
	
	
	/**
	 * 简单的15位  注册号验证
	 */
	public static final String REGISTERNO_REGEX = "[0-9a-zA-Z]{15}";
	
	
	/**
	 * 简单的身份证验证,仅支持15位的验证,不验证出生年月是否正常
	 */
	public static final String SIMPLE_ID_REGEX = "(^\\d{18}$)|(^\\d{15}$)";
	
	/**
	 * 简单的身份证验证,支持15位和18位身份证的验证,不验证出生年月是否正常
	 */
	public static final String SIMPLE_ID_REGEX_2 = "(^\\d{18}$)|(^\\d{15}$)";
	
	
	/**
	 * 验证用户名
	 */
	public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";
	
	/**
	 * 验证电话号码
	 */
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	
	/**
	 * 验证密码
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
 
    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
 
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
 
    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
 
    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
 
    /**
     * 校验用户名
     * 
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }
 
    /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }
 
    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
 
    /**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
 
    /**
     * 校验汉字
     * 
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }
 
    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }
 
    /**
     * 校验URL
     * 
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }
 
    /**
     * 校验IP地址
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }
 
    /**
     * 校验统一社会信用代码
     * 
     * @param unionCreditNo
     * @return
     */
    public static boolean isUnionCreditNo(String unionCreditNo) {
        return Pattern.matches(UNIONCREDITNO_REGEX, unionCreditNo);
    }
    
    
    /**
     * 校验注册号
     * 
     * @param registerNo
     * @return
     */
    public static boolean isRegisterNo(String registerNo) {
        return Pattern.matches(REGISTERNO_REGEX, registerNo);
    }
    
    
    public static void main(String[] args) {
        String username = "fdsdfsdj";
        System.out.println(RegexValidation.isUsername(username));
        System.out.println(RegexValidation.isChinese(username));
    }

}
