package com.xw.zkconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // 声明这是一个配置文件，类似于applicationcontext.xml
@EnableWebMvc // //开启注解，等同于<mvc:annotation-driven/>
@ComponentScan("com.xw.zkconfig.controller")
//@ImportResource({ "classpath*:applicationContext*.xml" })
public class WebConfig {

}
