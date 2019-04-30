package com.demo01.action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GenerateTokenAction extends BaseAction{

	private static final long serialVersionUID = -212772980185378633L;
	private String userName;
	private String password;
	private String token;
	private Map<String, Object> jsonRes;
	public String generateToken() {
		String token = UUID.randomUUID().toString();
		this.getRequest().getSession().setAttribute("token", token);
		this.setToken(token);
		return "form";
	}
	public String formSub() {
		jsonRes = new HashMap<String, Object>();
		String sessionToken = (String) this.getRequest().getSession().getAttribute("token");
		System.out.println(sessionToken);
		System.out.println(this.getToken());
		if(sessionToken == null || !sessionToken.equals(this.getToken())) {
			jsonRes.put("errorCode", 000002);
			jsonRes.put("msg", "表单不能重复提交");
			jsonRes.put("date", new Object());
			return "jsonstr";
		} else {
			this.getRequest().getSession().removeAttribute("token");
			return "formsuccess";
		}
		
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Map<String, Object> getJsonRes() {
		return jsonRes;
	}
	public void setJsonRes(Map<String, Object> jsonRes) {
		this.jsonRes = jsonRes;
	}
	
	
}
