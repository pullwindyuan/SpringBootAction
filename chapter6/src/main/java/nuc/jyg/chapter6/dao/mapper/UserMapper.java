package nuc.jyg.chapter6.dao.mapper;

import nuc.jyg.chapter6.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 11:36 2017/8/25.
 * @Descrip
 */
@Mapper
public interface UserMapper {
    /**
     * 查询单个用户
     *
     * @return
     */
    User queryUserById(@Param("id") Long id);

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
    Integer addUser(@Param("username") String username,
                    @Param("password") String passowrd, @Param("uri") String uri);

    /**
     * 更新用户信息
     *
     * @return
     */
    Integer updateUser(@Param("username") String username, @Param("password") String passowrd,
                       @Param("uri") String uri, @Param("id") Long id);

    /**
     * 删除用户
     *
     * @return
     */
    Integer deleteUser(@Param("id") Long id);
}
