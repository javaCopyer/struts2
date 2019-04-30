package com.demo01.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1952434260509450541L;
	private HttpServletResponse response;
	private  HttpServletRequest request;
	/**action代理类**/
	private ActionProxy proxy;
	
	public BaseAction() {
		super();
		this.proxy = ActionContext.getContext().getActionInvocation().getProxy();
	}

	public String getNameSpace() {
		String nameSpace = proxy.getNamespace();
		if("/".equals(nameSpace))
			nameSpace = "";
		return nameSpace;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	
	
	public HttpServletResponse getResponse() {
		response.setContentType("text/json;charset=utf-8");
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ActionProxy getProxy() {
		return proxy;
	}

	public void setProxy(ActionProxy proxy) {
		this.proxy = proxy;
	}
}
