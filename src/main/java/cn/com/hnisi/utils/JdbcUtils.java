package cn.com.hnisi.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库操作工具类
 *
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/11
 */
public class JdbcUtils
{
    private static DataSource ds;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    static
    {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getDataSource()
    {
        return ds;
    }

    /*
     * 从线程上获取一个数据库连接，并返回
     * 如果线程上没有，从连接池中获取一个数据库连接 ，并绑定到线程上，
     * 最后返回连接
     * @param
     * @return java.sql.Connection
     * @date 2019/4/12 14:37
     */
    public static Connection getConnection()
    {
        System.out.println("获取连接");
        try
        {
            Connection conn = tl.get();
            if (conn == null)
            {
                conn = ds.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    /*
     * 从获取线程上的连接，开启线程。
     * 如果线程上没有连接，先获取连接并绑定到线程
     * 最后开启事务
     * @param
     * @return void
     * @date 2019/4/12 14:39
     */
    public static void startTransaction()
    {
        System.out.println("开启事务");
        try
        {
            Connection conn = tl.get();
            if (conn == null)
            {
                conn = getConnection();
                tl.set(conn);
            }
            conn.setAutoCommit(false);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    /*
     * 从线程上获取连接，若不为空，提交事务
     * @param
     * @return void
     * @date 2019/4/12 14:41
     */
    public static void commitTransaction()
    {
        System.out.println("提交事务");
        try
        {
            Connection conn = tl.get();
            if (conn != null)
            {
                conn.commit();
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    /*
     * 关闭连接，还回连接池
     * 最后，移除线程上的连接
     * @param
     * @return void
     * @date 2019/4/12 14:41
     */
    public static void closeConnection()
    {
        System.out.println("关闭连接");
        try
        {
            Connection conn = tl.get();
            if (conn != null)
            {
                conn.close();
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            tl.remove();
        }
    }
}
