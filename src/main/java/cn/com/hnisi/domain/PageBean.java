package cn.com.hnisi.domain;

import java.util.List;

public class PageBean
{
    private List<Book> books;
    private int totalrecord;
    private int pagesize;
    private int totalpage;
    private int currentpage;
    private int previouspage;
    private int nextpage;
    private int[] pagebar;

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }

    public int getTotalrecord()
    {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord)
    {
        this.totalrecord = totalrecord;
    }

    public int getPagesize()
    {
        return pagesize;
    }

    public void setPagesize(int pagesize)
    {
        this.pagesize = pagesize;
    }

    public int getTotalpage()
    {
        this.totalpage = (this.totalrecord + (this.pagesize - 1)) / this.pagesize;
        return totalpage;
    }

    public int getCurrentpage()
    {
        return currentpage;
    }

    public void setCurrentpage(int currentpage)
    {
        this.currentpage = currentpage;
    }

    public int getPreviouspage()
    {
        if (this.currentpage - 1 < 1)
        {
            this.previouspage = 1;
        } else
            this.previouspage = this.currentpage - 1;
        return previouspage;
    }

    public int getNextpage()
    {
        if (this.currentpage + 1 > getTotalpage())
        {
            this.nextpage = getTotalpage();
        } else
            this.nextpage = this.currentpage + 1;
        return nextpage;
    }

    public int[] getPagebar()
    {
        int startpage;
        int endpage;

        if (getTotalpage() <= 10)
        {
            startpage = 1;
            endpage = this.totalpage;
        } else
        {
            startpage = this.currentpage - 4;
            endpage = this.currentpage + 5;

            if (startpage < 1)
            {
                startpage = 1;
                endpage = 10;
            }
            if (endpage > this.totalpage)
            {
                startpage = this.totalpage - 9;
                endpage = this.totalpage;
            }
        }

        this.pagebar = new int[endpage - startpage + 1];
        for (int i = startpage; i <= endpage; i++)
        {
            pagebar[i - startpage] = i;
        }

        return pagebar;
    }

}
