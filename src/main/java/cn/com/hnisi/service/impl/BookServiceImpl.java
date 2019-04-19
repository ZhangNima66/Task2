package cn.com.hnisi.service.impl;

import cn.com.hnisi.dao.IBookDao;
import cn.com.hnisi.domain.Book;
import cn.com.hnisi.domain.PageBean;
import cn.com.hnisi.domain.QueryInfo;
import cn.com.hnisi.domain.QueryResult;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.IBookService;

/**
 * 书籍业务接口实现
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/18
 */
public class BookServiceImpl implements IBookService
{
    private static IBookDao dao;
    static
    {
        dao = (IBookDao) BeanFactory.getBean("BookDao");
    }

    @Override
    public void addBook(Book book)
    {
        dao.insertBook(book);
    }

    @Override
    public Book findBookById(String id)
    {
        return dao.findBookById(id);
    }

    @Override
    public PageBean queryPage(QueryInfo info)
    {
        QueryResult queryResult = dao.pageQuery(info.getStartindex(), info.getPagesize(), info.getWhere(), info.getQueryvalue());
        PageBean bean = new PageBean();
        bean.setBooks(queryResult.getList());
        bean.setTotalrecord(queryResult.getTotalrecord());
        bean.setCurrentpage(info.getCurrentpage());
        bean.setPagesize(info.getPagesize());
        return bean;
    }

    @Override
    public void updateBook(Book book)
    {
        dao.updateBookById(book);
    }

    @Override
    public void deleteBookById(String id)
    {
        dao.deleteBookById(id);
    }
}
