package nuc.jyg.chapter7.controller;

import lombok.extern.log4j.Log4j2;
import nuc.jyg.chapter7.model.User;
import nuc.jyg.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 9:09 2017/9/7.
 * @Descrip
 */
@Controller
@Log4j2
@RequestMapping(path = "/jdbcTemplate")
public class JdbcTController {

    @Autowired
    UserService userService;

    private static final int REQUEST_SUCCESS = 1;
    private static final int REQUEST_FINAL = 0;

    @RequestMapping(path = "")
    public String jdbcTemplate() {
        return "home";
    }

    @RequestMapping(path = "/queryUserList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryUserList() {
        log.info("jdbctemplate - queryUserList: " + REQUEST_SUCCESS);
        List<User> users = userService.queryUserList();
        return users.toString();
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public void addUser() {
        log.info("jdbcTemplate - addUser: " + REQUEST_SUCCESS);
    }

    @RequestMapping(path = "/updateUser", method = RequestMethod.PUT)
    public void updateUser() {
        log.info("jdbcTemplate - updateUser: " + REQUEST_SUCCESS);
    }

    @RequestMapping(path = "/deleteUserById", method = RequestMethod.DELETE)
    public void deleteUserById() {
        // 状态码，状态信息message,true，响应response
        log.info("jdbcTemplate - deleteUserById: " + REQUEST_SUCCESS);
    }

}
