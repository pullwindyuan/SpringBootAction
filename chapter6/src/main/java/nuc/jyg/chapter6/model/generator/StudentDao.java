package nuc.jyg.chapter6.model.generator;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao {
    int insert(@Param("pojo") Student pojo);

    int insertSelective(@Param("pojo") Student pojo);

    int insertList(@Param("pojos") List<Student> pojo);

    int update(@Param("pojo") Student pojo);

    Student findById(@Param("id") Integer id);
}
