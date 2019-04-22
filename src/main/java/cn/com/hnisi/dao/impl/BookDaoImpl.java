package cn.com.hnisi.dao.impl;

import cn.com.hnisi.dao.IBookDao;
import cn.com.hnisi.domain.Book;
import cn.com.hnisi.domain.QueryResult;
import cn.com.hnisi.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 书籍持久层实现
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/15
 */
public class BookDaoImpl implements IBookDao
{
    @Override
    public void insertBook(Book book)
    {
        try
        {
            QueryRunner runner = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            String sql = "insert into mxz_book(id,name,price,author,publicationDate,image,description,category_id) values(?,?,?,?,?,?,?,?)";
            Object[] params = {book.getId(), book.getName(), book.getPrice(), book.getAuthor(),
                    new Date(book.getPublicationDate().getTime()),
                    book.getImage(), book.getDescription(),
                    book.getCategory_id()};
            runner.update(conn, sql, params);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book findBookById(String id)
    {
        try
        {
            QueryRunner runner = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            String sql = "select * from mxz_book where id=? and isDel=0";
            return runner.query(conn, sql, new BeanHandler<>(Book.class), id);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public QueryResult pageQuery(int startIndex, int pageSize, String where, Object param)
    {
        try
        {
            QueryRunner runner = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            QueryResult qr = new QueryResult();

            List<Book> list;
            int totalrecord;
            if (param == null || "".equals(param))
            {           // 不带条件，则返回所有书的分页数据
                String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT * FROM MXZ_BOOK where isDel=0) A WHERE ROWNUM < ?) WHERE RN >= ? ";
                Object[] params = {startIndex + pageSize, startIndex};
                list = runner.query(conn, sql, new BeanListHandler<>(Book.class), params);
                sql = "select count(*) from mxz_book where isDel=0";
                totalrecord = runner.query(conn, sql, new ScalarHandler<BigDecimal>()).intValue();
            } else       //用户带where条件，则方法返回分类下面的分页数
            {            // where条件的格式： String where = "and category_id=?";

                String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT * FROM MXZ_BOOK where isDel=0 "+ where +") A WHERE ROWNUM < ?) WHERE RN >= ?";
                Object[] params = {param, startIndex + pageSize, startIndex};
                list = runner.query(conn, sql, new BeanListHandler<>(Book.class), params);
                sql = "select count(*) from mxz_book where isDel=0 " + where;
                totalrecord = runner.query(conn, sql, new ScalarHandler<BigDecimal>(), param).intValue();
            }
            qr.setList(list);
            qr.setTotalrecord(totalrecord);
            return qr;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateBookById(Book book)
    {
        try
        {
            QueryRunner runner = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            String sql = "update mxz_book set name=?,price=?,author=?,publicationDate=?,image=?,description=?,category_id=?,isDel=? where id=?";
            Object[] params = {book.getName(), book.getPrice(), book.getAuthor(), new Date(book.getPublicationDate().getTime()),
                    book.getImage(), book.getDescription(), book.getCategory_id(), book.getIsDel(), book.getId()};
            runner.update(conn, sql, params);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBookById(String id)
    {
        try
        {
            QueryRunner runner = new QueryRunner();
            Connection conn = JdbcUtils.getConnection();
            String sql = "update mxz_book set isDel=1 where id=?";
            runner.update(conn, sql, id);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
