package nuc.jyg.chapter7.service;

import nuc.jyg.chapter7.model.User;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 20:53 2017/8/22.
 * @Descrip
 */
public interface UserService {

    List<User> queryUserList();

    Integer addUser(String username, String passowrd, String uri);

    Integer updateUser(String username, String passowrd, String uri, long id);

    Integer deleteUserById(long id);
}
