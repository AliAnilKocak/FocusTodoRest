package com.cale.focustodo.config;

import com.cale.focustodo.filters.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
    @Bean
    public FilterRegistrationBean<MyFilter> registrationBean() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/person/*");
        return registrationBean;
    }
}