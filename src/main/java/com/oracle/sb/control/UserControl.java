package com.oracle.sb.control;

import com.oracle.sb.model.User;
import com.oracle.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserService  userService;


    @RequestMapping("/login")
    public String login(User user, Model  model, HttpSession session){
        System.out.println("login method");

        User loginedUser=userService.processLogin(user);
        System.out.println(loginedUser);
        if(loginedUser==null)
        {
            return "/login.html";
        }
        else{
            session.setAttribute("user",loginedUser);
            return "/index";
        }
    }
    @RequestMapping("/register")
    public String register(User user,Model  model){
        System.out.println(user);
        System.out.println(userService);
        userService.processRegister(user);
        System.out.println("register method");
        User u1=new User(1,"tengsir1","123");
        User u2=new User(2,"tengsir2","12");
        User u3=new User(3,"tengsir3","223");

        ArrayList<User> us=new ArrayList<>();
        us.add(u1);
        us.add(u2);
        us.add(u3);
        model.addAttribute("users",us);


        return "/index";
    }

    /**
     * springBoot  返回json格式数据
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public User loadUserInfo(){
        User u=new User(10011,"jackson","NxY23Nas");
        return  u;
    }


}