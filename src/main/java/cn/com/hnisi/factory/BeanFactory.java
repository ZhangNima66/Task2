package cn.com.hnisi.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BeanFactory
{
	private static ResourceBundle bundle = ResourceBundle.getBundle("bean");
	//定义一个容器，用于存放配置文件内所有对象
	private static Map<String, Object> beans = new HashMap<String, Object>();
	static
	{
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements())
		{
			try
			{
				String key = keys.nextElement();
				String beanPath = bundle.getString(key);
				Object value = Class.forName(beanPath).newInstance();
				beans.put(key, value);
			} catch (Exception e)
			{
				throw new ExceptionInInitializerError(e);
			}
			
		}
	}
	
	public static Object getBean(String beanName)
	{
		return beans.get(beanName);
	}
	
//	public static Object getBean(String beanName)
//	{
//		try
//		{
//			//从配置文件读取类全名
//			String beanPath = bundle.getString(beanName);
//			return Class.forName(beanPath).newInstance();
//		} catch (Exception e)
//		{
//			throw new RuntimeException(e);
//		}
//	}
}
