package cn.com.hnisi.service;

import cn.com.hnisi.domain.Book;
import cn.com.hnisi.domain.PageBean;
import cn.com.hnisi.domain.QueryInfo;
import cn.com.hnisi.domain.QueryResult;

import java.util.List;

/**
 * 书籍的业务层
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/18
 */
public interface IBookService
{
    /*
     * 增加书籍记录
     * @param book
     * @return void
     * @date 2019/4/18 8:37
     */
    void addBook(Book book);
    /*
     *
     * @param id
     * @return cn.com.hnisi.domain.Book
     * @date 2019/4/18 8:37
     */
    Book findBookById(String id);
    /*
     * 分页查询书籍记录
     * @param startIndex	//起始偏移量
     * @param pageSize	    //每一页记录数
     * @param where	        //附加的查询条件
     * @param param	        //查询条件的值
     * @return java.util.List<cn.com.hnisi.domain.QueryResult> //查询结果集
     * @date 2019/4/18 8:39
     */
    PageBean queryPage(QueryInfo info);
    /*
     * 更新书籍记录信息
     * @param book
     * @return void
     * @date 2019/4/18 8:41
     */
    void updateBook(Book book);
    /*
     * 逻辑删除书籍
     * @param id
     * @return void
     * @date 2019/4/18 8:42
     */
    void deleteBookById(String id);
}
