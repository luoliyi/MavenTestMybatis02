package Controller;

import DAL.UserDao;
import Entity.Standard;
import Entity.User;
import Utils.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/doServlet")
public class doServlet extends BaseServlet {
    UserDao  dao=new UserDao();
    Standard style=null;
    public void getAllUsers(HttpServletRequest request,HttpServletResponse response){
        List<User> getAllUsers=dao.selectAllUsers();
        style=new Standard(200,"success request!",getAllUsers);
        try {
            response.getWriter().print(JSONUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllUsersByPage(HttpServletRequest request,HttpServletResponse response){
        int pageno=Integer.parseInt(request.getParameter("pageno"));
        int size=Integer.parseInt(request.getParameter("size"));
        List<User>getAllCar=dao.selectAllUsersByPage(pageno,size);
        style=new Standard(200,"success request!",getAllCar);
        try {
            response.getWriter().print(JSONUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCount(HttpServletRequest request,HttpServletResponse response){
        int count=dao.selectCount();
        try {
            response.getWriter().print(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insert(HttpServletRequest request,HttpServletResponse response){
        User user=getInfo(request,response);
        try {
            int result=dao.insertUser(user);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public User getInfo(HttpServletRequest request,HttpServletResponse response){
        String uname=request.getParameter("uname");
        int uage=Integer.parseInt(request.getParameter("uage"));
        int usex=Integer.parseInt(request.getParameter("usex"));
        String udesc=request.getParameter("udesc");
        //int cid=Integer.parseInt(request.getParameter("cid"));
        return new User(uname,uage,usex,udesc);
    }

    public  void update(HttpServletRequest request,HttpServletResponse response){

        int uid=Integer.parseInt(request.getParameter("uid"));
        User user=getInfo(request,response);
        //添加id
        user.setUid(uid);

        try {
            int result=dao.updateUser(user);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void delete(HttpServletRequest request,HttpServletResponse response){
        int uid=Integer.parseInt(request.getParameter("uid"));
        try {
            int result= dao.deleteUser(uid);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAll(HttpServletRequest request,HttpServletResponse response){
        String items=request.getParameter("items");
        String[] item=items.split(",");
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<item.length;i++){
            list.add(Integer.parseInt(item[i]));
        }
        int result=dao.deleteAll(list);
        try {
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
