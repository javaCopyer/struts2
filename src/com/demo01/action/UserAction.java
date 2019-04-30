package com.demo01.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import constant.WebConstant;

public class UserAction extends BaseAction{

	
	
	/**
	 * 
	 */
	private File file;
	private String title;
	private String userName;
	private String fileFileName;
	private Map<String, Object> jsonRes = new HashMap<String, Object>();
	private static final long serialVersionUID = -1067832060710439665L;
	public String login() {
		if(WebConstant.users.contains(userName)) {
			HttpServletRequest request = this.getRequest();
			HttpSession session = request.getSession();
			System.out.println("前：" + session.getId());
			session.invalidate();
			session = request.getSession();
			System.out.println("后：" + session.getId());
			session.setAttribute("user", userName);
			WebConstant.sessionMap.put(userName, session);
			jsonRes.put("code", "00000");
			jsonRes.put("msg", "登錄成功");
		} else {
			jsonRes.put("code", "00001");
			jsonRes.put("msg", "登錄失敗，用戶名錯誤");
		}
		return "jsonstr";
	}
	
	public void upload() throws Exception {
		System.out.println(title);
		FileInputStream fis = new FileInputStream(file);
		int length = 0;
		byte[] buffer = new byte[1024];
		FileOutputStream fos = new FileOutputStream("E:\\" + fileFileName);
		while((length = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, length);
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Object> getJsonRes() {
		return jsonRes;
	}
	public void setJsonRes(Map<String, Object> jsonRes) {
		this.jsonRes = jsonRes;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	
}
