package nuc.jyg.chapter7.dao.imp;

import nuc.jyg.chapter7.dao.UserDao;
import nuc.jyg.chapter7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 21:03 2017/8/22.
 * @Descrip
 */
@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> queryUserList() {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE username = ?", List.class); // required Type
    }

    @Override
    public Integer addUser(String username, String passowrd, String uri) {
        return jdbcTemplate.update("INSERT INTO user(username,password,uri) VALUES(?,?,?)", username, passowrd, uri);
    }

    @Override
    public Integer updateUser(String username, String passowrd, String uri, long id) {
        return jdbcTemplate.update("UPDATE user SET usernmae=?,password=?,uri=? WHERE id = ?", username, passowrd, uri, id);
    }

    @Override
    public Integer deleteUserById(long id) {
        return jdbcTemplate.update("DELETE FROM user WHERE id=?", id);
    }
}
