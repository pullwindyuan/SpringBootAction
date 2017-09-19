package nuc.jyg.chapter1.controller;

import io.swagger.annotations.*;
import nuc.jyg.chapter1.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:50 2017/9/8.
 * @Descrip
 */
@Controller
@Api("HelloController相关的Api")
public class SwaggerController { // http://localhost:8080/swagger-ui.html

    @ApiOperation("访问SpringBoot")
    @ApiResponses({
            @ApiResponse(code = 400, message = "访问路径错误或跳转错误", response = Exception.class),
            @ApiResponse(code = 404, message = "请求参数错误", response = Exception.class)
    })
    @GetMapping(path = {"/hello"})
    @ResponseBody
    public String Hello() {
        return "Hello Spring Boot!";
    }

    //url:customer?username=213&password=123
    @RequestMapping(path = {"/customer"}, method = {RequestMethod.GET})
    @ResponseBody
    public Customer visityCustomer(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        return customer;
    }

    //url:user/213/123
    @ApiOperation("visityuser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "username", dataType = "String",
                    required = true, value = "用户的姓名", defaultValue = "qwe"),
            @ApiImplicitParam(paramType = "path", name = "password", dataType = "String",
                    required = true, value = "用户的密码", defaultValue = "123")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求路径错误或请求跳转错误"),
            @ApiResponse(code = 404, message = "请求参数错误")

    })
    @RequestMapping(path = {"/user/{username}/{password}"}, method = {RequestMethod.GET})
    public String visityUser(@PathVariable("username") String username,
                             @PathVariable("password") String password,
                             Model model) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        model.addAttribute("user", customer);
        return "visityuser";
    }
}