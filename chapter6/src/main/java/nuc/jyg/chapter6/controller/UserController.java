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

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:26 2017/8/23.
 * @Descrip
 */
@Controller
@Log4j2
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/query", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryAllUser() {
        log.info("UserController -/ queryAllUser");
        String userString = userService.queryAllUser().toString();
        log.info("userList", userService.queryAllUser());
        return JsonUtil.getJsonString(JsonUtil.REQUEST_SUCCESS, userString);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String uri) {
        log.info("UserController -/ addUser");
        log.info("username:" + username + " - password:" + password + " - uri:" + uri);
        return JsonUtil.getJsonString(userService.addUser(username, password, uri));
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String uri,
                             @RequestParam long id) {
        log.info("UserController -/ updateUser");
        log.info("username:" + username + " - password:" + password + " - uri:" + uri + " - id:" + id);
        return JsonUtil.getJsonString(userService.updateUser(username, password, uri, id));
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(@RequestParam String id) {
        log.info("UserController -/ deleteUser - id: " + id, id);
        return JsonUtil.getJsonString(userService.deleteUser(Long.parseLong(id)));
    }

    @RequestMapping(path = "/queryone", method = RequestMethod.GET)
    public String queryUserById(@RequestParam String id,
                                Model model) {
        log.info("UserController -/ queryUserById - id: " + id, id);
        User user = userService.queryUserById(Long.parseLong(id));
        model.addAttribute("user", user);
        return "update";
    }
}