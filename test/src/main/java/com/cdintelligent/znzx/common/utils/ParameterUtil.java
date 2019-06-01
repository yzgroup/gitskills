package com.cdintelligent.znzx.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: ParameterUtil</p>
 * <p>Description: ParameterUtil</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/10/23 17:17</p>
 *
 * @author cb
 * @version 1.0
 **/
public class ParameterUtil
{
    /**
     * parameters
     */
    private static Map<String, String> parameters = new HashMap<String, String>();

    /**
     * 获取值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
    public static String get(String key, String defaultValue)
    {
        String value = parameters.get(key);
        if (null == value)
        {
            return defaultValue;
        }
        else
        {
            return value;
        }
    }

    /**
     * 获取值
     *
     * @param key 值
     * @return 值
     */
    public static String get(String key)
    {
        return get(key, "");
    }

    /**
     * 获取值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 是 否
     */
    public static boolean get(String key, boolean defaultValue)
    {
        try
        {
            return Boolean.valueOf(parameters.get(key));
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    public static Map<String, String> getParameters()
    {
        return parameters;
    }
}

