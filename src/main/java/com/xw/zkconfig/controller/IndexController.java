package com.xw.zkconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xw.zkconfig.config.PropertiesConfig;
import com.xw.zkconfig.service.TestServiceImpl;

@RestController
public class IndexController {

	@Value("${xw}")
	String xw;
	@Value("${xw2}")
	String xw2;
	@Value("${zk.addr}")
	String zkaddr;
	
	@Autowired
	private TestServiceImpl testServiceImpl;
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@RequestMapping("/")
	public String index() {
		testServiceImpl.test();
		return "helloword" + xw + xw2 + zkaddr;
	}
	
	@RequestMapping("/2")
	public String index2() {
		
		return "helloword" + propertiesConfig.getXw() + propertiesConfig.getXw2() + propertiesConfig.getZkaddr();
	}
}
