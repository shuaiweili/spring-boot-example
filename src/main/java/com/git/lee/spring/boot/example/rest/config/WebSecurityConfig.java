package com.git.lee.spring.boot.example.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LISHUAIWEI
 * @date 2018/1/8 15:17
 */
//@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{
    public final static String SESSION_KEY = "peak_user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getSecurityInterceptor());
        //exclude
        registration.excludePathPatterns("/error");
        registration.excludePathPatterns("/login**");

        //拦截配置
        registration.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();
            if (session.getAttribute(SESSION_KEY) != null)
                return true;

            //跳转登录页面
            response.sendRedirect("/login");
            return false;
        }
    }
}
