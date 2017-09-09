package nuc.jyg.chapter8.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 15:45 2017/7/16.
 * @Descrip
 */
//@EnableWebMvc
@Configuration
public class TestMvc extends WebMvcConfigurerAdapter{

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/illuos1ion/**").addResourceLocations("classpath:/illuos1ion/");
        super.addResourceHandlers(registry);
    }
}
