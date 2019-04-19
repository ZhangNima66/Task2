package cn.com.hnisi.dao.impl;

import cn.com.hnisi.dao.ICategoryDao;
import cn.com.hnisi.domain.Category;
import cn.com.hnisi.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 种类的持久层实现
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/15
 */
public class CategoryDaoImpl implements ICategoryDao
{
    @Override
    public void insertCategory(Category category)
    {
        try
        {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into mxz_category(id,name,description) values(?,?,?)";
            Object[] params = {category.getId(), category.getName(), category.getDescription()};
            runner.update(JdbcUtils.getConnection(), sql, params);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findCategoryById(String id)
    {
        try
        {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from mxz_category where id=? and isDel=0";
            return runner.query(JdbcUtils.getConnection(), sql, new BeanHandler<>(Category.class), id);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> findCategoryAll()
    {
        try
        {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from mxz_category where isDel=0";
            return runner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCategoryById(Category category)
    {
        try
        {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update mxz_category set name=?, description=?, isDel=? where id=?";
            Object[] params = {category.getName(), category.getDescription(), category.getIsDel(), category.getId()};
            runner.update(JdbcUtils.getConnection(), sql, params);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategoryById(String id)
    {
        try
        {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update mxz_category set isDel=1 where id=?";
            runner.update(JdbcUtils.getConnection(), sql, id);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
