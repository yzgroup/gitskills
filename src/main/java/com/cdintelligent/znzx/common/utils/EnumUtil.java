package com.cdintelligent.znzx.common.utils;

/**
 * <p>Description: 枚举工具类.</p>
 * <p>Copyright: Copyright(c)2017.</p>
 * <p>Company: 成都四方.</p>
 * <p>CreateTime: 2017/10/21.</p>
 *
 * @author SF2121
 * @version 1.0
 */
public class EnumUtil extends org.apache.commons.lang.enums.EnumUtils {

    /**
     * <p>Description: 根据索引值获取枚举对象.</p>
     * <p>Copyright: Copyright(c).</p>
     * <p>Company: sefosoft.</p>
     * <p>CreateTime: 2017/10/21.</p>
     *
     * @param clazz   类对象
     * @param ordinal 索引值
     * @param <T>     枚举对象
     * @return <T>   枚举对象
     * @author SF2121
     * @version 1.0
     */
    public static <T extends Enum<T>> T valueOf(Class<T> clazz, int ordinal) {
        return clazz.getEnumConstants()[ordinal];
    }

    /**
     * <p>Description: 根据名称获取枚举对象.</p>
     * <p>Copyright: Copyright(c).</p>
     * <p>Company: sefosoft.</p>
     * <p>CreateTime: 2017/10/21.</p>
     *
     * @param clazz 类对象
     * @param name  名称
     * @param <T>   枚举对象
     * @return <T>   枚举对象
     * @author SF2121
     * @version 1.0
     */
    public static <T extends Enum<T>> T valueOf(Class<T> clazz, String name) {
        return Enum.valueOf(clazz, name);
    }

}
