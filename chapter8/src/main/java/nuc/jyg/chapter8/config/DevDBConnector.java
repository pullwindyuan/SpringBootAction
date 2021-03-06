package nuc.jyg.chapter8.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 12:25 2017/7/13.
 * @Descrip
 */
@Component
@Profile("devdb") // 生产环境使用 取决于application.properties配置文件的spring.profiles.active属性的配置
public class DevDBConnector implements DBConnector {

    @Override
    public void configure() {
        System.out.println("devdb");
    }
}
