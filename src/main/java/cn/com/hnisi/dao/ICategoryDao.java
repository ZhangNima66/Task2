package cn.com.hnisi.dao;

import cn.com.hnisi.domain.Category;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * 种类的持久层接口
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/15
 */
public interface ICategoryDao
{
    /*
     * 增加种类
     * @param category
     * @return void
     * @date 2019/4/15 9:33
     */
    void insertCategory(Category category);
    /*
     * 通过id查找种类
     * @param id
     * @return cn.com.hnisi.domain.Category
     * @date 2019/4/15 9:33
     */
    Category findCategoryById(String id);
    /*
     * 查找所有种类
     * @param
     * @return java.util.List<cn.com.hnisi.domain.Category>
     * @date 2019/4/15 9:34
     */
    List<Category> findCategoryAll();
    /*
     * 更新种类信息
     * @param category
     * @return void
     * @date 2019/4/15 9:34
     */
    void updateCategoryById(Category category);
    /*
     * 逻辑删除种类
     * @param id
     * @return void
     * @date 2019/4/15 9:34
     */
    void deleteCategoryById(String id);
}
