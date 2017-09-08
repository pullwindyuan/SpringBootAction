package nuc.jyg.chapter6.model.generator;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService{

    @Resource
    private StudentDao studentDao;

    public int insert(Student pojo){
        return studentDao.insert(pojo);
    }

    public int insertSelective(Student pojo){
        return studentDao.insertSelective(pojo);
    }

    public int insertList(List<Student> pojos){
        return studentDao.insertList(pojos);
    }

    public int update(Student pojo){
        return studentDao.update(pojo);
    }
}
