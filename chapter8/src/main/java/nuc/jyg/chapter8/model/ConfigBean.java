package nuc.jyg.chapter8.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 21:36 2017/7/12.
 * @Descrip 配置文件读取测试 PropertySource/ConfigurationProperties
 */
// 这里需要注意启动类需要开启 EnableConfigurationProperties
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "JYG")
@Data
public class ConfigBean {

    private String name;
    private String think;
}
