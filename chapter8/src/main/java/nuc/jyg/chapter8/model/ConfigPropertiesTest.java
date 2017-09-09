package nuc.jyg.chapter8.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 22:11 2017/7/12.
 * @Descrip 配置文件读取测试 PropertySource/ConfigurationProperties
 */
// 这里需要注意启动类需要开启 EnableConfigurationProperties
@PropertySource("classpath:test.properties")// 多个配置文件时，声明读取哪个
@ConfigurationProperties(prefix = "people")
@Data
public class ConfigPropertiesTest {

    private String name;
    private String think;
}
