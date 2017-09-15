package nuc.jyg.chapter9.service;

import nuc.jyg.chapter9.Chapter9ApplicationTests;
import nuc.jyg.chapter9.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 1:52 2017/9/16.
 * @Descrip
 */
public class UserServiceTest extends Chapter9ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("zhangsan");
        Integer userId = userService.saveUser(user);

        // service 层利用断言判断检测方法
        Assert.assertEquals(new Integer(2), userId);
    }

}