package cn.com.hnisi.dao.impl;

import cn.com.hnisi.dao.IBookDao;
import cn.com.hnisi.domain.Book;
import cn.com.hnisi.domain.QueryResult;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class BookDaoImplTest
{
    private IBookDao dao = new BookDaoImpl();

    @Test
    public void insertBook()
    {
        Book book = new Book();
        book.setId("3");
        book.setName("Java基础教程3");
        book.setAuthor("张三");
        book.setPrice(new BigDecimal(199));
        book.setPublicationDate(new Date());
        book.setImage("1.jpg");
        book.setDescription("专注与Java基础的书籍");
        book.setCategoryId("2");

        dao.insertBook(book);
    }

    @Test
    public void findBookById()
    {
    }

    @Test
    public void pageQuery()
    {
        QueryResult queryResult = dao.pageQuery(1, 3, "and category_id=?", "1");
        System.out.println(queryResult);
    }

    @Test
    public void updateBookById()
    {
        Book book = dao.findBookById("1");
        book.setImage("2.jpg");
        dao.updateBookById(book);
        //System.out.println(book);
    }

    @Test
    public void deleteBookById()
    {
        dao.deleteBookById("1");
    }
}