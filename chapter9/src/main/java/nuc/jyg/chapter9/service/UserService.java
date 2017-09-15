package nuc.jyg.chapter9.service;

import nuc.jyg.chapter9.enums.ResultEnum;
import nuc.jyg.chapter9.exception.UserException;
import nuc.jyg.chapter9.model.User;
import org.springframework.stereotype.Service;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 23:20 2017/9/14.
 * @Descrip
 */
@Service
public class UserService {

    public void saveUser(Integer id) throws Exception {
        User user = new User();
        String username = user.getUsername();
        String password = user.getPassword();

        if ("".equals(username) || username == null) {
            throw new UserException(ResultEnum.USERNAME_ILLEGALITY);
        } else if ("".equals(password) || password == null) {
            throw new UserException(ResultEnum.PASSWORD_ILLEGALITY);
        }
    }
}
