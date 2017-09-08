package nuc.jyg.chapter6.service.imp;

import lombok.extern.log4j.Log4j2;
import nuc.jyg.chapter6.dao.dao.UserDao;
import nuc.jyg.chapter6.model.User;
import nuc.jyg.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:27 2017/8/23.
 * @Descrip
 */
@Service
@Log4j2
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 查询单个用户
     *
     * @return
     */
    @Override
    public User queryUserById(Long id) {
        return userDao.queryUserById(id);
    }

    /**
     * 查询全部用户
     *
     * @return
     */
    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    /**
     * 添加用户
     */
    @Override
    public Integer addUser(String username, String password, String uri) {
        return userDao.addUser(username, password, uri);
    }

    /**
     * 更新用户信息
     */
    @Override
    public Integer updateUser(String username, String password, String uri, Long id) {
        return userDao.updateUser(username, password, uri, id);
    }

    /**
     * 删除用户
     */
    @Override
    public Integer deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

}
