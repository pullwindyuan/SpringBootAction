package nuc.jyg.chapter7.config;

import nuc.jyg.chapter7.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:33 2017/7/24.
 * @Descrip
 */
@Component
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        // 映射为 user 的控制器下的所有路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/login/home").excludePathPatterns("/index", "/");
        super.addInterceptors(registry);
    }
}
