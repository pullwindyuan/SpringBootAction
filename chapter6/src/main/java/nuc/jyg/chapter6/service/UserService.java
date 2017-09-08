package nuc.jyg.chapter6.service;


import nuc.jyg.chapter6.model.User;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:26 2017/8/23.
 * @Descrip
 */
public interface UserService {

    /**
     * 查询单个用户
     *
     * @return
     */
    User queryUserById(Long id);

    /**
     * 查询全部用户
     *
     * @return
     */
    List<User> queryAllUser();

    /**
     * 添加用户
     *
     * @return
     */
    Integer addUser(String username, String passowrd, String uri);

    /**
     * 更新用户信息
     *
     * @return
     */
    Integer updateUser(String username, String passowrd, String uri, Long id);

    /**
     * 删除用户
     *
     * @return
     */
    Integer deleteUser(Long id);

}
