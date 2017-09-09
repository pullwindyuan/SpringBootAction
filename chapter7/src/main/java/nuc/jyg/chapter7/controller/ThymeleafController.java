package nuc.jyg.chapter7.controller;

import lombok.extern.log4j.Log4j2;
import nuc.jyg.chapter7.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 15:54 2017/7/17.
 * @Descrip
 */
@Controller
@Log4j2
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        List<User> userList = new ArrayList<User>();
        User user = new User(1, "jyg", "jyg", "http://www.jiyongguang.xin");
        userList.add(user);

        user = new User(1, "lyn", "lyn", "http://www.jiyongguang.xin");
        userList.add(user);

        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("userList", userList);
        log.info("操作成功!");
        return modelAndView;
    }

    @RequestMapping(path = "/test/modelandview", method = RequestMethod.GET)
    public ModelAndView testModelAndView(User user) {// 表单参数名与user对象属性名自动匹配赋值
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);
        return new ModelAndView("/home", data);
    }
}
