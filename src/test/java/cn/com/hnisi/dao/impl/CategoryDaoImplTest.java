package cn.com.hnisi.dao.impl;

import cn.com.hnisi.dao.ICategoryDao;
import cn.com.hnisi.domain.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryDaoImplTest
{
    private ICategoryDao dao = new CategoryDaoImpl();

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void insertCategory()
    {
        Category category = new Category();
        category.setId("2");
        category.setName("JavaSE");
        category.setDescription("Java基础课程");

        dao.insertCategory(category);
    }

    @Test
    public void findCategoryById()
    {
        Category category = dao.findCategoryById("2");
        System.out.println(category);

    }

    @Test
    public void findCategoryAll()
    {
        List<Category> categories = dao.findCategoryAll();
        System.out.println(categories);
    }

    @Test
    public void updateCategoryById()
    {
        Category category = new Category();
        category.setId("1");
        category.setName("JavaEE");
        category.setDescription("Java基础课程");
        category.setIsDel(0);

        dao.updateCategoryById(category);

    }

    @Test
    public void deleteCategoryById()
    {
        dao.deleteCategoryById("1");
    }
}