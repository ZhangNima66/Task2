package cn.com.hnisi.utils;

import cn.com.hnisi.Exception.ErrorValueException;
import cn.com.hnisi.domain.Book;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author maxuezhi
 * @company sinobest
 * @date 2019/4/22
 */
public class WebUtils
{
    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass)
    {
        try
        {
            Map<String, String[]> map = request.getParameterMap();
            T bean = beanClass.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Book upload(HttpServletRequest request) throws ErrorValueException
    {
        Book book = new Book();
        ErrorValueException eve = null;
        try
        {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //缓存目录
            //factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            upload.setFileSizeMax(1024 * 1024 * 500);
            List<FileItem> parseRequest = upload.parseRequest(request);
            for (FileItem item : parseRequest)
            {
                if (item.isFormField())
                {
                    // 注册Date转换器
                    ConvertUtils.register(new Converter()
                    {

                        public Object convert(Class type, Object value)
                        {
                            if (value == null)
                                return null;
                            String str = (String) value;
                            if (str.trim().equals(""))
                                return null;

                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            try
                            {
                                return df.parse(str);
                            } catch (Exception e)
                            {
                                throw new RuntimeException(e);
                            }
                        }
                    }, Date.class);

                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    if (value == null || "".equals(value))
                    {
                        if (eve ==null)
                            eve = new ErrorValueException();
                        if ("name".equals(name))
                            eve.setBook_name("书名不能为空");
                        else if("author".equals(name))
                            eve.setAuthor("作者名不能为空");
                        else if("price".equals(name))
                            eve.setBook_price("价格不能为空");
                        else if("description".equals(name))
                            eve.setDescription("描述不能为空");
                        else if("publicationDate".equals(name))
                            eve.setPublicationDate("出版日期不能为空");
                    }
                    BeanUtils.setProperty(book, name, value);

                } else
                {
                    String fileName = item.getName();
                    if (fileName == null || "".equals(fileName))
                        continue;
                    String savePath = "D:\\Tomcat_upload\\Task2_Servlet";
                    String saveName = UUID.randomUUID().toString() + fileName;

                    InputStream in = item.getInputStream();
                    OutputStream out = new FileOutputStream(savePath + File.separator + saveName);
                    try
                    {
                        int len = 0;
                        byte[] buffer = new byte[1024];
                        while ((len = in.read(buffer)) > 0)
                        {
                            out.write(buffer, 0, len);
                        }
                    } finally
                    {
                        if (in != null)
                            in.close();
                        out.close();
                        item.delete();
                    }
                    book.setImage(saveName);
                }
            }
            if (book.getId() == null || "".equals(book.getId()))
                book.setId(UUID.randomUUID().toString());
            if (eve != null)
            {
                throw eve;
            }
            return book;
        } catch (ErrorValueException e)
        {
            throw eve;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
