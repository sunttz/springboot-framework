package com.stt.springbootframework.config;


import com.stt.springbootframework.controller.interceptor.OneInterceptor;
import com.stt.springbootframework.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/th/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/ftl/**")
                .addPathPatterns("/th/**");

        super.addInterceptors(registry);
    }

}
