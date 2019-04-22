package cn.com.hnisi.controller;

import cn.com.hnisi.Exception.ErrorValueException;
import cn.com.hnisi.domain.Book;
import cn.com.hnisi.domain.Category;
import cn.com.hnisi.factory.BeanFactory;
import cn.com.hnisi.service.impl.BookServiceImpl;
import cn.com.hnisi.service.impl.CategoryServiceImpl;
import cn.com.hnisi.utils.WebUtils;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet
{
    private static BookServiceImpl service;
    private static CategoryServiceImpl categoryService;
    static
    {
        service = (BookServiceImpl) BeanFactory.getBean("BookService");
        categoryService = (CategoryServiceImpl) BeanFactory.getBean("CategoryService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


        String method = request.getParameter("method");
        if ("add".equals(method))
        {
            add(request, response);
            return;
        }
        if ("addUI".equals(method))
        {
            addUI(request, response);
            return;
        }
        if ("editUI".equals(method))
        {
            editUI(request, response);
            return;
        }
        if ("edit".equals(method))
        {
            edit(request, response);
            return;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!ServletFileUpload.isMultipartContent(request))
        {
            request.setAttribute("message", "不支持的操作！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        try
        {
            Book book = WebUtils.upload(request);
            service.updateBook(book);
            request.setAttribute("message", "修改成功！");
        } catch (Exception e)
        {
            e.printStackTrace();
            request.setAttribute("message", "修改失败！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void editUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        Book book = service.findBookById(id);
        List<Category> categories = categoryService.getCategoryAll();
        request.setAttribute("book",book);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/editbook.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!ServletFileUpload.isMultipartContent(request))
        {
            request.setAttribute("message", "不支持的操作！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        try
        {
            Book book = WebUtils.upload(request);
            service.addBook(book);
            request.setAttribute("message", "添加成功！");
        }catch (ErrorValueException e)
        {
            request.setAttribute("e",e);
            request.getRequestDispatcher("/BookServlet?method=addUI").forward(request,response);
            return;
        }catch (Exception e)
        {
            e.printStackTrace();
            request.setAttribute("message", "添加失败！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Category> categories = categoryService.getCategoryAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/addbook.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getSession();
        doPost(request, response);
    }


}
