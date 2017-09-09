package nuc.jyg.chapter8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:50 2017/7/13.
 * @Descrip
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {
/*
    @Autowired
    DBConnector dbConnector;// 注入接口，调用接口方法的时候会自动引用自己的实现类
*/
    @Autowired
    Environment environment;

    @RequestMapping(path = {"/db", "", "/"}, method = RequestMethod.GET)
    public String hellTask() {
//        dbConnector.configure();
        return "hello task !! myage is" + environment.getProperty("");
    }
}
