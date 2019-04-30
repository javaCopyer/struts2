package com.demo01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import constant.WebConstant;

public class UserLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4237284295886282271L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("登录拦截验证");
		HttpServletRequest request = (HttpServletRequest) actionInvocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) actionInvocation
				.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		response.setContentType("text/json;charset=utf-8"); 
		HttpSession session = request.getSession();
		if (session != null) {
			System.out.println(session.getId());
			String userName = (String) session.getAttribute("user");
			if (null == userName || "".equals(userName)) {
				response.getWriter().print("账号未登录！");
				return null;
			} else {
				HttpSession nowSession = WebConstant.sessionMap.get(userName);
				if (nowSession.getId() != session.getId()) {
					response.getWriter().print("賬號以在其他地區登錄，請重新登錄");
					return null;
				}

			}
		} else {
			return null;
		}

		return actionInvocation.invoke();
	}

}
