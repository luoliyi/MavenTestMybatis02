package DAL;
import Entity.User;
import java.util.List;


/*各取所长，配置灵活，在代码中不需要引用很长的id名称，面向接口编程*/
public interface IUserMapper {
    /**
     * 根据学生编号获得学生对象
     */
    User selectStudentByUid(int uid);

    /**
     * 根据学生姓名获得学生集合
     */
    List<User> selectStudentsByName(String name);

    /**
     * 添加学生
     */
    int insertStudent(User entity);

    /**
     * 更新学生
     */
    int updateStudent(User entity);

    /**
     * 删除学生
     */
    int deleteStudent(int uid);

    /*获得集合*/
    List<User> selectAll();
}
