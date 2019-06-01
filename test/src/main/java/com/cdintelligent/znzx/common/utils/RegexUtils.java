package com.cdintelligent.znzx.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title: RegexUtils</p>
 * <p>Description: RegexUtils</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/11/16 19:33</p>
 *
 * @author cb
 * @version 1.0
 **/
public abstract class RegexUtils
{
    /**
     * 电话号码正则
     */
    public static final String MOBILE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    /**
     * n位纯数字
     */
    public static final String NUMBER = "^\\d{n}$";

    /**
     * 由至少3位数字、26个英文字母或者下划线组成的字符串
     */
    public static final String NW = "^\\w{3,20}$";

    /**
     * IP地址
     */
    public static final String IP = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

    /**
     * 用户名  字母开头，允许5-16字节，允许字母数字下划线
     */
    public static final String LOGIN_NAME = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

    /**
     * 强密码  必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间
     */
    public static final String STRONG_PWD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$";

    /**
     * 匹配是否符合正则表达式pattern 匹配返回true
     *
     * @param str     匹配的字符串
     * @param pattern 匹配模式
     * @return boolean
     */
    private static boolean validateRegExp(String str, String pattern)
    {
        return validateRegExp(str, pattern, null);
    }

    /**
     * 匹配是否符合正则表达式pattern 匹配返回true
     *
     * @param str     匹配的字符串
     * @param pattern 匹配模式
     * @param length  匹配长度
     * @return boolean
     */
    private static boolean validateRegExp(String str, String pattern, Integer length)
    {
        if (null == str || str.trim().length() <= 0)
        {
            return false;
        }
        if (length != null && length != 0)
        {
            pattern = pattern.replace("n", length.toString());
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }


//    public static void main(String[] args)
//    {
//        boolean b = validateRegExp("192.168.2.91", IP);
//        System.out.println(b);
//    }
}
