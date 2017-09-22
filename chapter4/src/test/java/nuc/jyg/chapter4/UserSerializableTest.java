package nuc.jyg.chapter4;

import nuc.jyg.chapter4.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 19:08 2017/9/22.
 * @Descrip
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSerializableTest {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test() throws Exception {

        //保存对象
        User user = new User("ji", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("yong", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("guang", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("ji").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("yong").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("guang").getAge().longValue());
    }
}