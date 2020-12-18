package com.example.login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ログイン画面のコントローラー部分はWebSecurityConfigが担っているので、
 * ViewNameと画面の対応付けを行うために実装
 * @author jun
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * "login.html"を呼び出す
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

}
