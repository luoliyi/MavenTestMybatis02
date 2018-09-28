package DAL;

import Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserDao  implements IUserMapper{

    //初始化
    InputStream stream=UserDao.class.getClassLoader().getResourceAsStream("mybatisconf.xml");
    SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
    SqlSession session=ssf.openSession();
    /*初始化一个映射文件*/
    IUserMapper mapper=session.getMapper(IUserMapper.class);

    public User selectStudentByUid(int uid) {
        return mapper.selectStudentByUid(uid);
    }

    public List<User> selectStudentsByName(String name) {
        return mapper.selectStudentsByName(name);
    }

    /*增删改记得要session.commit(),否则无效*/
    public int insertStudent(User entity) {
        System.out.println("beforeuid:"+entity.getUid());
        mapper.insertStudent(entity);
        session.commit();
        System.out.println("afteruid:"+entity.getUid());
        return entity.getUid();
    }

    public int updateStudent(User entity) {
        return mapper.updateStudent(entity);
    }

    public int deleteStudent(int uid) {
        return mapper.deleteStudent(uid);
    }

    public List<User> selectAll() {
        return mapper.selectAll();
    }
}
