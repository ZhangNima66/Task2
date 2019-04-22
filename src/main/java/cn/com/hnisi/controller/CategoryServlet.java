package cn.com.hnisi.controller;

import cn.com.hnisi.domain.Category;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.impl.CategoryServiceImpl;
import cn.com.hnisi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CategoryServlet extends HttpServlet
{
    private static CategoryServiceImpl service;
    static
    {
        service = (CategoryServiceImpl) BeanFactory.getBean("CategoryService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String method = request.getParameter("method");
        if ("addUI".equals(method))
        {
            addUI(request, response);
            return;
        }
        if ("add".equals(method))
        {
            add(request, response);
            return;
        }
        if ("listUI".equals(method))
        {
            listUI(request, response);
            return;
        }
    }
    private void listUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Category> categories = service.getCategoryAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/listcategory.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            Category c = WebUtils.request2Bean(request, Category.class);
            c.setId(UUID.randomUUID().toString());
            service.addCategory(c);
            request.setAttribute("message", "添加成功！");
        } catch (Exception e)
        {
            e.printStackTrace();
            request.setAttribute("message", "添加失败！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/addcategory.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
