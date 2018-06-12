package com.xw.zkconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * spring父容器，父子容器一般分工，父容器负责业务处理，业务逻辑组件、数据库操作组件等
 */
@Configuration
@ComponentScan(basePackages = { "com.xw.zkconfig" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@ImportResource({ "classpath*:applicationContext*.xml" })
public class RootConfig {

}
