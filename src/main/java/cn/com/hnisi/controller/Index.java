package cn.com.hnisi.controller;

import cn.com.hnisi.domain.Category;
import cn.com.hnisi.domain.PageBean;
import cn.com.hnisi.domain.QueryInfo;
import cn.com.hnisi.domain.QueryResult;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.IBookService;
import cn.com.hnisi.service.ICategoryService;
import cn.com.hnisi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Index extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
        ICategoryService cService = (ICategoryService) BeanFactory.getBean("CategoryService");
        IBookService bService = (IBookService) BeanFactory.getBean("BookService");
        List<Category> categories = cService.getCategoryAll();
        PageBean pagebean = bService.queryPage(info);
        request.setAttribute("categories",categories);
        request.setAttribute("bean",pagebean);
        request.setAttribute("category",info.getQueryvalue());

        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
