package cn.com.hnisi.controller;

import cn.com.hnisi.domain.Category;
import cn.com.hnisi.domain.QueryInfo;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UIServlet extends HttpServlet
{
    private static ICategoryService cService;

    static
    {
        cService = (ICategoryService) BeanFactory.getBean("CategoryService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String jsp = request.getParameter("jsp");
        if ("head".equals(jsp))
        {
            request.getRequestDispatcher("/WEB-INF/jsp/head.jsp").forward(request, response);
            return;
        }
        if ("left".equals(jsp))
        {
            List<Category> categories = cService.getCategoryAll();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/WEB-INF/jsp/left.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
