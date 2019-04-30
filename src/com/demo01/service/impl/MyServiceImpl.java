package com.demo01.service.impl;

import org.springframework.stereotype.Service;

@Service(value="myService")
public class MyServiceImpl {
	
	public String getName() {
		return "MyServiceImpl";
	}
}

