package nuc.jyg.chapter4.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 21:43 2017/9/8.
 * @Descrip
 */
public class JedisUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(JedisUtilTest.class);

    private JedisPool jedisPool;
    private Jedis jedis;

    public static void main(String[] args) {
        JedisUtilTest jedisUtilTest = new JedisUtilTest();
//        jedisUtilTest.testBaseString();
        jedisUtilTest.testMap();
    }

    public void setUp() {
        jedisPool = new JedisPool();
        jedis = jedisPool.getResource();
    }

    public void testBaseString() {

        setUp();
        jedis.set("name", "minxs");
        System.out.println(jedis.get("name"));//minxs

        jedis.append("name", "tes");
        System.out.println(jedis.get("name"));//minxstes

        jedis.set("name", "non");
        System.out.println(jedis.get("name"));//non

        jedis.del("name");
        System.out.println(jedis.get("name"));//null

        jedis.mset("username", "jyg", "password", "jyg0723");
        System.out.println(jedis.mget("username", "password"));//jyg jyg0723

    }

    public void testMap() {

        setUp();
        System.out.println(jedis.get("username"));//jyg

        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "qwe");
        map.put("password", "QWE");
        jedis.hmset("map", map);//同时设置多个 域值对,即设置一个map进去

        List<String> list = jedis.hmget("map", "password");
        System.out.println(list);//[QWE]

        jedis.hdel("map", "password");
        System.out.println(jedis.hget("map", "password"));//null

        System.out.println(jedis.hlen("map"));//1
        System.out.println(jedis.hexists("map", "username"));//true
        System.out.println(jedis.hkeys("map"));//[username]
        System.out.println(jedis.hvals("map"));//[qwe]

        jedis.hset("map", "password", "qwe");
//        System.out.println(jedis.hmget("map","username","password"));
        System.out.println(jedis.hvals("map"));
    }
}
