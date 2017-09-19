package nuc.jyg.chapter7.controller;

import nuc.jyg.chapter7.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 23:17 2017/9/13.
 * @Descrip
 */
@Controller
public class DataBindingController {

    @PostMapping(value = "/{id}")
    @ResponseBody
    public User userAdd(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return user;
    }

}
