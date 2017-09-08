package nuc.jyg.chapter1.controller;

import io.swagger.annotations.*;
import nuc.jyg.chapter1.model.User;
import nuc.jyg.chapter1.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.logging.Logger;

import static springfox.documentation.builders.PathSelectors.regex;

@RestController
@RequestMapping("/user")
@Api("UserController相关的api")
public class UserController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    // http://localhost:8080/swagger-ui.html
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "username", dataType = "String",
                    required = true, value = "用户的姓名"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String",
                    required = true, value = "用户密码")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求路径错误或跳转路径错误"),
            @ApiResponse(code = 404, message = "请求参数错误", response = RuntimeException.class)
    })
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestHeader("username") String usernmae,
                        @RequestParam("password") String password) {
        return userService.getUser(usernmae, password);
    }

    @RestController
    @RequestMapping("/user")
    public class SwaggerDemoController {
        @RequestMapping(value = "/demo2.do")
        String getDemo() {
            return "Hello World \n" + "Spring boot3";
        }

        @Bean
        public Docket swaggerSpringMvcPlugin() {
            ApiInfo apiInfo = new ApiInfo("sample of springboot", "sample of springboot", null, null, null, null, null);
            Docket docket = new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/user/.*")).build()
                    .apiInfo(apiInfo).useDefaultResponseMessages(false);
            return docket;
        }
    }
}
