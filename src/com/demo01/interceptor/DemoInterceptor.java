package com.demo01.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DemoInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8424819238657917313L;
	private String auth;
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("auth>>>>>>>>>>>>>>>>>>:" + auth);
		String result = "";
		String message = "";
		try {
			result = actionInvocation.invoke();
			return result;
		} catch(Exception e) {
			result = "exception";
			System.out.println("异常信息>>>>>>>>>>>>>>>" + message);
			e.printStackTrace();
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			message = stringWriter.toString();
			HttpServletRequest request = (HttpServletRequest) actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			request.setAttribute("message", message);
			return result;
			
		}
		

		
	}

}
