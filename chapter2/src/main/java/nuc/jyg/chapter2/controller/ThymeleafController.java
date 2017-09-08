package nuc.jyg.chapter2.controller;

import nuc.jyg.chapter2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 21:01 2017/9/8.
 * @Descrip
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping(path = "/interview", method = {RequestMethod.GET})
    public String interview(@RequestParam(name = "name", required = false, defaultValue = "interview") String name,
                            Model model) {
        model.addAttribute("templateName", name);
        return "interview";
    }

    @RequestMapping(value = "/visityuser", method = RequestMethod.GET)
    public String visityUser(ModelMap modelMap) {
        User user = new User();
        user.setUsername("jyg");
        user.setPassword("jyg");
        modelMap.addAttribute("user", user);
        return "visityuser";
    }
}
