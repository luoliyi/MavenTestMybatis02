package DAL;

import Entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao udao=null;
    @Before
    public void before(){
        udao=new UserDao();
    }

    @Test
    public void selectStudentById() {
       User u= udao.selectStudentByUid(3);
        System.out.println(u.toString());
    }
    @Test
    public void selectAll(){
        List<User> userList=udao.selectAll();
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void selectStudentsByName() {
    }

    @Test
    public void insertStudent() {
    }

    @Test
    public void updateStudent() {
        udao.insertStudent(new User("luosan",20,0,"my name is luosan!"));
    }

    @Test
    public void deleteStudent() {
    }
}