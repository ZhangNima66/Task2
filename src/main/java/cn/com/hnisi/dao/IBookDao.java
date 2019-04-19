package cn.com.hnisi.dao;

import cn.com.hnisi.domain.Book;
import cn.com.hnisi.domain.QueryResult;

/**
 * 书籍的持久层接口
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/15
 */
public interface IBookDao
{
    /*
     * 增加书籍
     * @param book
     * @return void
     * @date 2019/4/15 10:25
     */
    void insertBook(Book book);
    /*
     * 通过id查找书籍
     * @param id
     * @return cn.com.hnisi.domain.Book
     * @date 2019/4/15 10:25
     */
    Book findBookById(String id);
    /*
     * 按种类 分页查找书籍
     * @param startIndex	分页起始偏移量
     * @param pageSize	    每一次查询的记录数
     * @param where	        查询条件，
     * @param param	        查询条件内容；
     * @return cn.com.hnisi.domain.QueryResult  查询结果集：查询到的书籍的记录与记录数
     * @date 2019/4/15 10:26
     */
    QueryResult pageQuery(int startIndex, int pageSize, String where, Object param);
    /*
     * 更新记录
     * @param book
     * @return void
     * @date 2019/4/15 10:29
     */
    void updateBookById(Book book);
    /*
     * 逻辑删除记录
     * @param id
     * @return void
     * @date 2019/4/15 10:29
     */
    void deleteBookById(String id);
}
