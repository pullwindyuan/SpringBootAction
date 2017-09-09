package nuc.jyg.chapter8.controller;

import nuc.jyg.chapter8.model.ConfigBean;
import nuc.jyg.chapter8.model.ConfigPropertiesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 21:42 2017/7/12.
 * @Descrip
 */
@RestController
@RequestMapping(path = "/config")
public class ConfigPropertiesController {

    @Autowired
    ConfigBean configBean;

    @Autowired
    ConfigPropertiesTest configPropertiesTest;

    @RequestMapping(path = "/properties", method = RequestMethod.GET)
    public String configProperties() {
        return "整个实体属性获取 @ConfigurationProperties 方式: " +
                configBean.getName() + ":" + configBean.getThink();
    }

    @GetMapping(path = "/propertiestest")
    public String configPropertiesTest() {
        return configPropertiesTest.getName() + ":" + configPropertiesTest.getThink();
    }

}
