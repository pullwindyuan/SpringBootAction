package nuc.jyg.chapter5.repository;

import nuc.jyg.chapter5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 21:46 2017/9/5.
 * @Descrip
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*
    * 通过解析方法名创建查询
    * */
    User findByName(String name);

    /*
    * 通过解析方法名创建查询
    * */
    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
