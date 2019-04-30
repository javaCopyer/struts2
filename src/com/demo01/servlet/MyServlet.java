package com.demo01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.demo01.service.impl.MyServiceImpl;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = -7655747959646316127L;
//	@Resource
	private MyServiceImpl myServiceImpl;
	private static ApplicationContext applicationContext = new XmlWebApplicationContext();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		myServiceImpl = (MyServiceImpl) applicationContext.getBean("myService");
		PrintWriter out = resp.getWriter();
		out.print(myServiceImpl.getName());
	}
	
}
