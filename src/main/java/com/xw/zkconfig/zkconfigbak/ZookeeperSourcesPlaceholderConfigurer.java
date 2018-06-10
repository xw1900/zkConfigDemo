package com.xw.zkconfig.zkconfigbak;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;

import com.dangdang.config.service.ConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;


public class ZookeeperSourcesPlaceholderConfigurer extends org.springframework.context.support.PropertySourcesPlaceholderConfigurer {
	
	@SuppressWarnings("rawtypes")
	@Override
	public void setPropertySources(PropertySources propertySources) {
		
		super.setPropertySources(propertySources);
	}
}
