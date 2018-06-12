package com.xw.zkconfig.zkconfig;

import org.springframework.core.env.PropertySources;

public class ZookeeperSourcesPlaceholderConfigurer
		extends org.springframework.context.support.PropertySourcesPlaceholderConfigurer {

	@SuppressWarnings("rawtypes")
	@Override
	public void setPropertySources(PropertySources propertySources) {
		super.setPropertySources(propertySources);
	}
}
