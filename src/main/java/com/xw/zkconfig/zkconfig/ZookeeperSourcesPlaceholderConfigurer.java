//package com.xw.zkconfig.zkconfig;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Properties;
//
//import org.springframework.core.env.PropertySource;
//import org.springframework.core.env.PropertySources;
//
//import com.dangdang.config.service.ConfigGroup;
//import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
//
//
//public class ZookeeperSourcesPlaceholderConfigurer extends org.springframework.context.support.PropertySourcesPlaceholderConfigurer {
//	
//	private static Map<String, String> ctxPropertiesMap = new HashMap<String, String>();
//	//private static Map<String, String> nodePathMap = new HashMap<String, String>();
//	private static Map<String, ConfigGroup> groupPropertiesMap = new HashMap<String, ConfigGroup>();
//		
//	@SuppressWarnings("rawtypes")
//	@Override
//	public void setPropertySources(PropertySources propertySources) {
//		for (Iterator iter = propertySources.iterator(); iter.hasNext();) {
//			PropertySource propSource = (PropertySource)iter.next();
//			if(propSource instanceof PropertiesResource){
//				for (Object key : ((Properties)propSource.getSource()).keySet()) {  
//		            String keyStr = key.toString();  
//		            String value = ((Properties)propSource.getSource()).getProperty(keyStr);  
//		            ctxPropertiesMap.put(keyStr, value);  
//		        }
//			}else{
//				ConfigGroup configNode = (ConfigGroup)propSource.getSource();
//				for (Object key : configNode.keySet()) {  
//		            String keyStr = key.toString();  
//		            String value = configNode.get(keyStr);  
//		            ctxPropertiesMap.put(keyStr, value);
//		           /* if (configNode instanceof ZookeeperConfigGroup) {
//		            	nodePathMap.put(keyStr, ((ZookeeperConfigGroup)configNode).getNode());
//					}*/
//				}
//				if (configNode instanceof ZookeeperConfigGroup) {
//					groupPropertiesMap.put(((ZookeeperConfigGroup)configNode).getNode(), configNode);
//				}
//				
//			}
//		}
//		super.setPropertySources(propertySources);
//	}
//	
//    public static String getContextProperty(String key) {  
//        return ctxPropertiesMap.get(key);  
//    }
//    
//    /*public String getGroupName(String key){
//    	return nodePathMap.get(key);
//    }*/
//    
//    public Map<String, String> getPropertiesByGroupName(String groupName){
//    	return groupPropertiesMap.get(groupName);
//    }
//    
//    public static String getPropertiesByGroupName(String groupName, String key){
//    	if (groupPropertiesMap.get(groupName) != null) {
//    		return groupPropertiesMap.get(groupName).get(key);
//		}else{
//			return "";
//		}
//    }
//    
//    public static String getPropertiesByGlobalGroup(String key){
//    	ConfigGroup globalGroup = groupPropertiesMap.get(ZookeeperSourceFactory.ZK_GLOBAL_GROUP_NAME);
//    	if (globalGroup != null) {
//    		return globalGroup.get(key);
//		}else{
//			return "";
//		}
//    }
//}
