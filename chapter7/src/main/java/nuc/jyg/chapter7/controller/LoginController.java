package nuc.jyg.chapter7.controller;

import nuc.jyg.chapter7.model.User;
import nuc.jyg.chapter7.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:09 2017/7/25.
 * @Descrip
 */
@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           HttpServletRequest request) {
        if (username.equals("admin") && password.equals("admin")) {
            User user = new User(1, username, password, "http://www.jiyongguang.xin");
            request.getSession().setAttribute("user", user);
            return "redirect:/login/home"; // 按访问映射来redirect
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpServletRequest request) {
        if (username.equals("admin") && password.equals("admin")) {
            return "redirect:/index"; // 按访问映射来redirect
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        List<User> userList = new ArrayList<User>();
        User user = new User(1, "jyg", "jyg", "http://www.jiyongguang.xin");
        userList.add(user);

        user = new User(1, "lyn", "lyn", "http://www.jiyongguang.xin");
        userList.add(user);
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
            return JsonUtil.getJsonString(JsonUtil.REQUEST_Fail, "用户名或密码错误");
        }
    }
}
