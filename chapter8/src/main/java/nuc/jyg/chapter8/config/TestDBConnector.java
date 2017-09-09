package nuc.jyg.chapter8.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 12:25 2017/7/13.
 * @Descrip
 */
@Component
@Profile("testdb")// 测试环境使用 取决于application.properties配置文件的spring.profiles.active属性的配置
public class TestDBConnector implements DBConnector {

    @Override
    public void configure() {
        System.out.println("testdb");
    }
}
