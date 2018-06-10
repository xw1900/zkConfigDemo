package com.xw.zkconfig.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {

	@Value("${xw}")
	String xw;
	@Value("${xw2}")
	String xw2;
	

	@Value("${zk.addr}")
	String zkaddr;
	
	public void test() {
		System.out.println("service " + xw + xw2 + zkaddr);
	}
}
