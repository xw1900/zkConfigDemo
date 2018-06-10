package com.xw.zkconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {

	@Value("${xw}")
	private String xw;
	@Value("${xw2}")
	private String xw2;
	@Value("${zk.addr}")
	private String zkaddr;
	
	public String getXw() {
		return xw;
	}
	public String getXw2() {
		return xw2;
	}
	public String getZkaddr() {
		return zkaddr;
	}
	
	
}
