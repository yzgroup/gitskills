package com.cdintelligent.znzx.common.utils;

import java.util.List;

import com.cdintelligent.znzx.common.pojo.Pagination;

/**
 * <p>Title: PaginationUtil</p>
 * <p>Description: PaginationUtil</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/6/14 9:45</p>
 *
 * @author cb
 * @version 1.0
 **/
public class PaginationUtil
{
    /**
     * <p>Description:description</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/6/14 </p>
     * <p>@author cb</p>
     *
     * @param result result
     * @return com.sefon.common.model.Pagination<T> description
     * @version 1.0
     */
    public static <T> Pagination<T> packagePaginationData(List<T> result, Long total, int limit)
    {
        Pagination<T> pagination = new Pagination<T>();
        pagination.setTotal(total);
        pagination.setResult(result);
        pagination.setLimit(limit);
        return pagination;
    }

}
