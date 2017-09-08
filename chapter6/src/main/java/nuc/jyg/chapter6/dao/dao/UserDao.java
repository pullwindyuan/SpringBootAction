package nuc.jyg.chapter6.dao.dao;

import lombok.extern.log4j.Log4j2;
import nuc.jyg.chapter6.model.User;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:28 2017/8/23.
 * @Descrip
 */
@Mapper
@Repository
@SuppressWarnings("ALL")
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User queryUserById(@Param("id") Long id);

    @Select("select * from user")
    @Results(id = "userList", value = {
            @Result(id = true, column = "id", property = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "username", property = "username", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "uri", property = "uri", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<User> queryAllUser();

    // 模糊查询
    @SelectProvider(type = UserSqlBuilder.class, method = "queryUserByParams")
    List<User> queryUserByCondition(Map<String, Object> params);

    @Insert("insert into user(username,password,uri) values(#{username},#{password},#{uri}) ")
    Integer addUser(@Param("username") String username,
                    @Param("password") String password, @Param("uri") String uri);

    @Update("update user set username=#{username},password=#{password},uri=#{uri} where id = #{id}")
    Integer updateUser(@Param("username") String username, @Param("password") String password,
                       @Param("uri") String uri, @Param("id") Long id);

    @Delete("delete from user where id = #{id}")
    Integer deleteUser(@Param("id") Long id);

    @DeleteProvider(type = UserSqlBuilder.class, method = "deleteUserById")
    Integer deleteUserById(@Param("ids") String[] ids);

    @Log4j2
    class UserSqlBuilder {
        public String queryUserByParams(final Map<String, Object> params) {
            StringBuilder sql = new StringBuilder("select * from user where 1=1");
            if (!StringUtils.isEmpty((String) params.get("username"))) {
                sql.append("and username like '%").append((String) params.get("username")).append("'%");
            } else if (!StringUtils.isEmpty((String) params.get("uti"))) {
                sql.append("and uri like '%").append((String) params.get("uri")).append("%'");
            }
            log.info("查询的sql语句：" + sql.toString());
            return sql.toString();
        }

        public String deleteUserById(final String[] ids) {
            StringBuilder sql = new StringBuilder("delete from user where id in(");
            for (int i = 0; i < ids.length; ++i) {
                if (i == ids.length - 1) {
                    sql.append(ids[i]);
                } else {
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            log.info("删除的sql语句：" + sql.toString());
            return sql.toString();
        }
    }
}
