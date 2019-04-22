package cn.com.hnisi.domain;

public class QueryInfo
{
	private int currentpage = 1;
	private int pagesize = 3;
	private int startindex;

	private String queryname = "category_id";
	private String queryvalue;
	private String where;

	public int getCurrentpage()
	{
		return currentpage;
	}

	public void setCurrentpage(int currentpage)
	{
		this.currentpage = currentpage;
	}

	public int getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public int getStartindex()
	{
		this.startindex = (this.currentpage - 1) * this.pagesize + 1;
		return startindex;
	}

	public String getQueryname()
	{
		return queryname;
	}

	public void setQueryname(String queryname)
	{
		this.queryname = queryname;
	}

	public String getQueryvalue()
	{
		return queryvalue;
	}

	public void setQueryvalue(String queryvalue)
	{
		this.queryvalue = queryvalue;
	}

	public String getWhere()
	{
		if (this.queryname == null || "".equals(queryname.trim()))
		{
			return "";
		} else
		{
			//this.where = "and category_id=?";
			where = "and " + queryname + "=?";
		}
		return where;
	}

}
