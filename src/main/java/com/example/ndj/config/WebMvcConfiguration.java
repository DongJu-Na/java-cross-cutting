package com.example.ndj.config;

import com.example.ndj.filter.CommonFilter;
import com.example.ndj.interceptor.LoggerInterceptor;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {


    @Value("${spring.profiles.active}")
    private String activeProfile;
    private static final String[] INCLUDE_PATHS = {
            "/posts/*",
            "/comments/*"
    };


    @Bean
    public FilterRegistrationBean<CommonFilter> filterBean() {

        FilterRegistrationBean<CommonFilter> registrationBean = new FilterRegistrationBean<>(new CommonFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);

        if(activeProfile.equals("local")){
            registrationBean.addUrlPatterns("/*");
        }else{
            registrationBean.setUrlPatterns(Arrays.asList(INCLUDE_PATHS));
        }

        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(activeProfile.equals("local")){
            registry.addInterceptor(new LoggerInterceptor())
                    .excludePathPatterns("/*");
        }else{
            registry.addInterceptor(new LoggerInterceptor())
                    .excludePathPatterns(INCLUDE_PATHS);
        }

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
