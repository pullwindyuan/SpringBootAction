package nuc.jyg.chapter6.controller;

import lombok.extern.log4j.Log4j2;
import nuc.jyg.chapter6.model.User;
import nuc.jyg.chapter6.service.UserService;
import nuc.jyg.chapter6.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:09 2017/7/25.
 * @Descrip
 */
@Log4j2
@Controller
//@RequestMapping(path = "/login")
public class LoginToController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           HttpServletRequest request) {
        if (username.equals("admin") && password.equals("admin")) {
            User user = new User(1, username, password, "http://www.jiyongguang.xin");
            request.getSession().setAttribute("user", user);
            return "home"; // 按访问映射来redirect
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        Model model) {
        if (username.equals("admin") && password.equals("admin")) {
            List<User> userList = userService.queryAllUser();
            log.info(userList.toString());
            model.addAttribute("userList", userList);
            return "home"; // 按访问映射来redirect
        }
        log.info(username + password);
        return "redirect:/";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        List<User> userList = userService.queryAllUser();
        model.addAttribute("userList", userList);
        return "home";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (username.equals("admin") && password.equals("admin")) {
            User user = new User(1, username, password, "http://www.jiyongguang.xin");
            request.getSession().setAttribute("user", user);
            return JsonUtil.getJsonString(JsonUtil.REQUEST_SUCCESS);
        } else {
            return JsonUtil.getJsonString(JsonUtil.REQUEST_FINAL, "用户名或密码错误");
        }
    }
}
