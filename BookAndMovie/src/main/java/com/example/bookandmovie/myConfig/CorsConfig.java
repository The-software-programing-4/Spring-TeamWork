package com.example.bookandmovie.myConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:8081")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")    // 配置跨域请求支持的方式
                .allowCredentials(true)    // 配置是否允许发送Cookie，用于 凭证请求， 默认不发送cookie
                .maxAge(3600)
                .allowedHeaders("*");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /images/**是静态映射， file:/root/images/是文件在服务器的路径
        registry.addResourceHandler("/templates/**")
               .addResourceLocations("file:/Users/fancy/Software_Project/software_project/Spring-TeamWork/BookAndMovie/src/main/resources/templates/");
             //addResourceLocations("file:/home/selmiss_ftp/BAM/src/main/resources/templates/");
    }
}
