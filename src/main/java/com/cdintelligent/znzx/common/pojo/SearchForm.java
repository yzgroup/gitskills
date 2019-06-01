package com.cdintelligent.znzx.common.pojo;

/**
 * <p>Title: SearchForm</p>
 * <p>Description: SearchForm</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/8/21 12:19</p>
 *
 * @author cb
 * @version 1.0
 **/
public class SearchForm
{
    /**
     * 当前页码
     */
    private int pageNum=1;

    /**
     * 每页显示记录数, 默认为15
     */
    private int pageSize=15;

    /**
     * 关键字模糊查询
     */
    private String keyword;

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
    	 if (pageNum <= 0)
         {
             this.pageNum = 1;
         }
         else
         {
             this.pageNum = pageNum;
         }
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        if (pageSize <= 0)
        {
            this.pageSize = 15;
        }
        else
        {
            this.pageSize = pageSize;
        }
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
}
