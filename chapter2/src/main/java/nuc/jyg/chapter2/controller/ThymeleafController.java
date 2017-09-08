package nuc.jyg.chapter2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(path = {"/interview"}, method = {RequestMethod.GET})
    public String interview(@RequestParam(name = "name", required = false, defaultValue = "interview") String name,
                            Model model) {

        model.addAttribute("templateName",name);
        return "interview";
    }
}
