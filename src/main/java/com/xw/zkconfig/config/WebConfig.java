package com.xw.zkconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 子容器，仅加载web组件之类的beans，例如controllers、view resolvers和handler mappings
 * 
 * 子容器可以读取到父容器的bean，例如service，但是父容器读不到子容器的，如controller。
 * 配置文件也一样，父子容器各自独立，像此处没有将配置文件加载到子容器，则获取不到，可以在子容器也加载一份，或者通过在父容器暴露一个component，子容器注进来即可
 */
@Configuration // 声明这是一个配置文件，类似于applicationcontext.xml
@EnableWebMvc // //开启注解，等同于<mvc:annotation-driven/>
@ComponentScan("com.xw.zkconfig.controller")
public class WebConfig {

}
