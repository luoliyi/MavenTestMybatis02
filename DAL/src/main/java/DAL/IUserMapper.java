package DAL;
import Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/*各取所长，配置灵活，在代码中不需要引用很长的id名称，面向接口编程*/
public interface IUserMapper {
    /**
     * 根据学生编号获得学生对象
     */
    User selectUserByUid(int uid);

    /**
     * 根据学生姓名获得学生集合
     */
    List<User> selectUsersByName(String name);

    /**
     * 添加学生
     */
    int insertUser(User entity);

    /**
     * 更新学生
     */
    int updateUser(User entity);

    /**
     * 删除学生
     */
    int deleteUser(int uid);

    /*获得集合*/
    List<User> selectAllUsers();

    /*注解写在接口里面*/
    List<User> selectMohu(@Param("uname")String uname,@Param("usex") int usex);

    List<User> selectTwo(@Param("cid") String cid);

    int selectCount();

    int deleteAll(@Param("list") List<Integer> list);

    List<User> selectAllUsersByPage(@Param("pagelimit") int pagelimit,@Param("size") int size);
}
