package cn.com.hnisi.service;

import cn.com.hnisi.domain.Category;

import java.util.List;

/**
 * 种类的业务层
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/18
 */
public interface ICategoryService
{
    /*
     * 增加种类记录
     * @param category
     * @return void
     * @date 2019/4/18 8:26
     */
    void addCategory(Category category);
    /*
     * 通过Id 查找种类，返回种类对象
     * @param id
     * @return cn.com.hnisi.domain.Category
     * @date 2019/4/18 8:26
     */
    Category findCategoryById(String id);
    /*
     * 获取所有种类
     * @param
     * @return java.util.List<cn.com.hnisi.domain.Category>
     * @date 2019/4/18 8:27
     */
    List<Category> getCategoryAll();
    /*
     * 更新种类信息
     * @param category
     * @return void
     * @date 2019/4/18 8:27
     */
    void updateCategory(Category category);
    /*
     * 逻辑删除种类
     * @param id
     * @return void
     * @date 2019/4/18 8:27
     */
    void deleteCategory(String id);
}
