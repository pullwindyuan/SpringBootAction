package nuc.jyg.chapter4.po;

import java.io.Serializable;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:58 2017/9/20.
 * @Descrip
 */
public class User implements Serializable {

    private static final long serialVersionUID = 384502558107314898L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
