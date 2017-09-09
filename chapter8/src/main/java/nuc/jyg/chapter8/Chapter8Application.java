package nuc.jyg.chapter8;

import nuc.jyg.chapter8.model.ConfigBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
@EnableConfigurationProperties(ConfigBean.class)
public class Chapter8Application {

    @Value("${JYG.name}")
    private String name;

    @Value("${JYG.think}")
    private String think;

    @RequestMapping(path = "/attrubite", method = RequestMethod.GET)
    public String attrubite() {
        return "单属性获取 @Value 方式: " +
                name + ": " + think;
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter8Application.class, args);
    }
}
