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

    /*注意，别关闭session.否则报错Executor was closed.*/

    public User selectUserByUid(int uid) {
        return mapper.selectUserByUid(uid);
    }

    public List<User> selectUsersByName(String name) {
        return mapper.selectUsersByName(name);
    }

    public int insertUser(User entity) {
        int result=mapper.insertUser(entity);
        session.commit();
        return result;
    }

    public int updateUser(User entity) {
        int result=mapper.updateUser(entity);
        session.commit();
        return result;
    }

    public int deleteUser(int uid) {
        int result=mapper.deleteUser(uid);
        session.commit();
        return result;
    }

    public List<User> selectAllUsers() {
        return mapper.selectAllUsers();
    }

    public List<User> selectMohu(String uname, int usex) {
        return mapper.selectMohu(uname,usex);
    }

    public List<User> selectTwo(String cid) {
        return mapper.selectTwo(cid);
    }

    public int selectCount() {
        return mapper.selectCount();
    }

    public int deleteAll(List<Integer>items) {
        int result= mapper.deleteAll(items);
        session.commit();
        return result;
    }

    public List<User> selectAllUsersByPage(int pageno, int size) {
        int pagelimit=(pageno-1)*size;
        return mapper.selectAllUsersByPage(pagelimit,size);
    }
}
