package com.demo01.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.demo01.service.impl.MyServiceImpl;

import config.configPojo;
import constant.WebConstant;


public class DemoAction extends BaseAction{
	
	private static final long serialVersionUID = 3143201770359727904L;
	private configPojo configPojo;
	
	
	private MyServiceImpl myService;
	private Map<String, String> map;
	private Map<String, Object> jsonRes;
	
	/**下载, 图片**/
	private InputStream imageStream;
	private String fileName; 
	public String index() {
		System.out.println("index>>>>>>");
		System.out.println(myService.getName());
		System.out.println(configPojo.getUrl() + " " + configPojo.getUserName() + " " + configPojo.getPassword());
		return "input";
	}
	public void api() throws IOException {
		System.out.println("api sessionid:" + this.getRequest().getSession().getId());
		map = new HashMap<String, String>();
		map.put("name", "张超");
		map.put("age", "18");
		
		String result = JSON.toJSONString(map);
		getResponse().setContentType("text/json;charset=utf-8"); 
		getResponse().getWriter().print(result);
	}
	
	public String demo1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "张超");
		this.setJsonRes(map);
		return WebConstant.jsonResName;
	}
	
	
	public String download() throws Exception {
		this.setFileName(URLEncoder.encode("张超.jpg", "utf-8"));
		imageStream = new FileInputStream(new File("G:/10.jpg"));
		
		return WebConstant.dowmloadName;
	}
	
	
	
	
	public Map<String, Object> getJsonRes() {
		return jsonRes;
	}
	public void setJsonRes(Map<String, Object> jsonRes) {
		this.jsonRes = jsonRes;
	}
	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MyServiceImpl getMyService() {
		return myService;
	}
	public void setMyService(MyServiceImpl myService) {
		this.myService = myService;
	}
	public configPojo getConfigPojo() {
		return configPojo;
	}
	public void setConfigPojo(configPojo configPojo) {
		this.configPojo = configPojo;
	}
	
	
	
	
	
}
