package nuc.jyg.chapter1.service;

import nuc.jyg.chapter1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:51 2017/9/8.
 * @Descrip
 */
@Service
public class UserService {

    @Autowired
    User user;

    public User getUser(String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
