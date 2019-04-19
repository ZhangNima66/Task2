package cn.com.hnisi.service.impl;

import cn.com.hnisi.dao.ICategoryDao;
import cn.com.hnisi.domain.Category;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.ICategoryService;

import java.util.List;

/**
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/18
 */
public class CategoryServiceImpl implements ICategoryService
{
    private static ICategoryDao dao;
    static
    {
        dao = (ICategoryDao) BeanFactory.getBean("CategoryDao");
    }

    @Override
    public void addCategory(Category category)
    {
        dao.insertCategory(category);
    }

    @Override
    public Category findCategoryById(String id)
    {
        return dao.findCategoryById(id);
    }

    @Override
    public List<Category> getCategoryAll()
    {
        return dao.findCategoryAll();
    }

    @Override
    public void updateCategory(Category category)
    {
        dao.updateCategoryById(category);
    }

    @Override
    public void deleteCategory(String id)
    {
        dao.deleteCategoryById(id);
    }
}
