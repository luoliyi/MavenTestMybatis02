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
    public void selectUserById() {
       User u= udao.selectUserByUid(3);
        System.out.println(u.toString());
    }
    @Test
    public void selectAll(){
        List<User> userList=udao.selectAllUsers();
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void selectMohu(){
        List<User> userList=udao.selectMohu("i",0);
        for (User u:userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void selectTwo(){
        List<User>  users=udao.selectTwo("4");
        for(User u:users){
            System.out.println(u.toString());
        }
    }
}