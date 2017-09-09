package nuc.jyg.chapter7.service.imp;

import nuc.jyg.chapter7.dao.UserDao;
import nuc.jyg.chapter7.model.User;
import nuc.jyg.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:52 2017/8/22.
 * @Descrip
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    @Override
    public Integer addUser(String username, String passowrd, String uri) {
        return userDao.addUser(username, passowrd, uri);
    }

    @Override
    public Integer updateUser(String username, String passowrd, String uri, long id) {
        return userDao.updateUser(username, passowrd, uri, id);
    }

    @Override
    public Integer deleteUserById(long id) {
        return userDao.deleteUserById(id);
    }
}
