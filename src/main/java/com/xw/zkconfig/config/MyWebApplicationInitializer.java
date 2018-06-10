package com.xw.zkconfig.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 相当于web.xml，负责配置DispatcherServlet、初始化Spring MVC容器和Spring容器
 * 这种方式配置DispatcherServlet需要支持Servlert 3.0的容器，例如Apache Tomcat 7或者更高版本的。
 * 
 * 一般：
 * DispatcherServlet（mvc容器WebConfig）仅加载web组件之类的beans，例如controllers（控制器）、view resolvers（视图解析器）和处理器映射（handler mappings）
 * ContextLoaderListener加载应用中的其他类型的beans——例如业务逻辑组件、数据库操作组件等等。
 */

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 用于获取Spring应用容器的配置文件，这个容器由ContextLoaderListener创建
	 * 定义了Spring应用根容器中的beans
	 * 
	 * 根容器，也可以return null 然后
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
//		return null;
	}

	/**
	 * 获取Spring MVC子应用容器。Spring MVC应用容器中的beans
	 * 当DispatcherServlet启动时，会创建一个Spring MVC应用容器并开始加载配置文件中定义好的beans。
	 * 通过getServletConfigClasses()方法，可以获取由DispatcherServlet加载的定义在WebConfig.class中的beans。
	 * 
	 * Spring MVC容器是根容器的子容器，子容器可以看到根容器中定义的beans，反之不行。
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * 负责指定需要由DispatcherServlet映射的路径，从"/"开始
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 初始化项目的过滤器
	 */
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return super.getServletFilters();
	}

}
