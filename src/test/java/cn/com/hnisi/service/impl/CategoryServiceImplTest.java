package cn.com.hnisi.service.impl;

import cn.com.hnisi.domain.Category;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.ICategoryService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryServiceImplTest
{
    private static ICategoryService service;

    @Test
    public void addCategory()
    {
    }

    @Test
    public void findCategoryById()
    {
        service = (ICategoryService) BeanFactory.getBean("CategoryService");
        Category id = service.findCategoryById("1");
        System.out.println(id);
    }

    @Test
    public void getCategoryAll()
    {
    }

    @Test
    public void updateCategory()
    {
    }

    @Test
    public void deleteCategory()
    {
    }
}