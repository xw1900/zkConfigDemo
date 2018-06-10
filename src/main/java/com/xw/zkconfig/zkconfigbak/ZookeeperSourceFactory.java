package com.xw.zkconfig.zkconfigbak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;
import org.springframework.core.io.Resource;

import com.dangdang.config.service.ConfigGroup;
import com.dangdang.config.service.support.spring.ConfigGroupResource;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;
import com.google.common.base.Preconditions; 

public class ZookeeperSourceFactory {
	
	public static final String ZK_GLOBAL_GROUP_NAME = "global";
	
	public static final String DEFAULT_ROOT_NODE_VERSION = "default";

	static Logger LOGGER = LoggerFactory.getLogger(ZookeeperSourceFactory.class);
	
	static Properties props = new Properties();
	 

	public static PropertySources create(List<ConfigGroup> configGroups) {
		Preconditions.checkNotNull(configGroups);
		final MutablePropertySources sources = new MutablePropertySources();
		for (ConfigGroup configGroup : configGroups) {
			sources.addLast(new ConfigGroupResource(configGroup));
		}
		sources.addLast(new PropertiesResource("properties" + "@" + UUID.randomUUID(), props));
		return sources;
	}

	public static PropertySources create(Resource[] locations) {
		if(null != locations && locations.length > 0){
			for(Resource resource:locations){
				if(resource.exists()){
					try {
						props.load(resource.getInputStream());
					} catch (IOException e) {
						LOGGER.warn(e.getMessage(), e);
					}
				}
			}
		}

		String zkServerAddr	= Preconditions.checkNotNull(StringUtils.trim(props.getProperty("zk.addr")));
		String rootNodePath	= Preconditions.checkNotNull(StringUtils.trim(props.getProperty("zk.rootNode")));
		
		List<ConfigGroup> configGroups = new ArrayList<ConfigGroup>();
		ZookeeperConfigProfile globalConfigProfile = new ZookeeperConfigProfile(zkServerAddr, rootNodePath, DEFAULT_ROOT_NODE_VERSION);
		ConfigGroup globalConfigGroup = new ZookeeperConfigGroup(globalConfigProfile, ZK_GLOBAL_GROUP_NAME);
		configGroups.add(globalConfigGroup);
		
		String appModule 	= Preconditions.checkNotNull(StringUtils.trim(props.getProperty("app.module")));
		String appGroups 	= StringUtils.trim(props.getProperty("app.groups"));
		String appVersion 	= StringUtils.trim(props.getProperty("app.version"));
		ZookeeperConfigProfile configProfile = null;
		if (StringUtils.isNotBlank(appGroups)) {
			String appNodePath = rootNodePath + "/" + appModule;

			configProfile = new ZookeeperConfigProfile(zkServerAddr, appNodePath, appVersion);
			 
			String[] nodes = appGroups.trim().split(",");
			Preconditions.checkNotNull(nodes);
			for (int i = 0; i < nodes.length; i++) {
				//configNodes.add(configFactory.getConfigNode(nodes[i]));
				configGroups.add(new ZookeeperConfigGroup(configProfile, nodes[i]));
			}
		}
		return create(configGroups);
	}

}
