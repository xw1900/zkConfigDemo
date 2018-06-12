package com.xw.zkconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xw.zkconfig.config.PropertiesConfig;
import com.xw.zkconfig.service.TestServiceImpl;

/**
 * 
 *
 */
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
	
	@RequestMapping("/1")
	public String index() {
		testServiceImpl.test();
		return xw + xw2 + zkaddr;
	}
	
	@RequestMapping("/2")
	public String index2() {
		return propertiesConfig.getXw() + propertiesConfig.getXw2() + propertiesConfig.getZkaddr();
	}

	public static void main(String[] args) {
		Long i = 12L;  
		Long j = 12L;  
		Long m = 195L;  
		Long n = 195L;  
		System.out.println(i==j);//true  
		System.out.println(m==n);//false  
		System.out.println(i.equals(j));//true  
		System.out.println(m.equals(n));//true  
		
		Long id = null;
		Long id2 = 333L;
		System.out.println(id2.equals(id));
		System.out.println(id == id2);
	}

}
