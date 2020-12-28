package com.gsitm.career.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 외부 자원 핸들러
 * @author leejinho
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 외부 이미지 첨부
	 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/images/**")
        .addResourceLocations("file:///C:/fileUpload/images/");
    }
}
