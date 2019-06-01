package com.cdintelligent.znzx.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * <p>Description: 时间工具类.</p>
 * <p>Copyright: Copyright(c) 2017.</p>
 * <p>Company: 成都四方.</p>
 * <p>CreateTime: 2017/1/10.</p>
 *
 * @author SF2121
 * @version 1.0
 */
public abstract class DateUtils
{

    public static final String DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_YYYYMMDD = "yyyy-MM-dd";
    /**
     * yyyyMMddhhmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static Date parse(String pattern, String source)
    {
        if (StringUtils.isEmpty(source))
        {
            return null;
        }

        try
        {
            return new SimpleDateFormat(pattern).parse(source);
        }
        catch (ParseException e)
        {
            throw new RuntimeException("can not parse " + source + " pattern " + pattern, e);
        }
    }

    public static String format(String pattern, Date source)
    {
        if (source == null)
        {
            return null;
        }

        return new SimpleDateFormat(pattern).format(source);
    }

    /**
     * <p>Description: 获取当前时间</p>
     * <p>Copyright: Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime: 2017.10.28</p>
     *
     * @param pattern 返回时间格式
     * @return String
     * @author ngl
     * @version 1.0
     */
    public static String currentTime(String pattern)
    {
        return format(pattern, new Date());
    }

    /**
     * <p>Description: 获取时间的前后多少天</p>
     * <p>Copyright: Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime: 2017.10.28</p>
     *
     * @param pattern 返回时间格式
     * @param source 时间
     * @param num 前后多少天
     * @return String
     * @author ngl
     * @version 1.0
     */
    public static String getDateForNum(String pattern, String source, int num)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            if (StringUtils.isNotEmpty(source))
            {
                date = new SimpleDateFormat(pattern).parse(source);
            }
            else
            {
                date = new Date();
            }
        }
        catch (ParseException e)
        {
            throw new RuntimeException("can not parse " + source + " pattern " + pattern, e);
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + num);

        String dayAfter = new SimpleDateFormat(pattern).format(c.getTime());
        return dayAfter;
    }
}
