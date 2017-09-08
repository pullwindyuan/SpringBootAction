package nuc.jyg.chapter1.model;

import org.springframework.stereotype.Component;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:52 2017/9/8.
 * @Descrip
 */
//@ConfigurationProperties(prefix = "user")
@Component
public class User {

    // 通过@Value注解可以根据名称注入配置文件中定义的内容
    //    @Value("${user.id}")
    private int id;

    //    @Value("${user.username}")
    private String username;

    //    @Value("${user.password}")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
