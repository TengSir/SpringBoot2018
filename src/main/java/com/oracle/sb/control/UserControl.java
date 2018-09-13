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

        System.out.println("login user info:"+user);
        User loginedUser=userService.processLogin(user);
        if(loginedUser==null)
        {
            model.addAttribute("loginResult","sucess");

            return "login.html";
        }
        else{
            session.setAttribute("user",loginedUser);
            model.addAttribute("loginResult","fail");
            return "index";
        }
    }
    public String other(){

        return null;
    }
    @RequestMapping("/register")
    public String register(User user,Model  model){
        System.out.println("register metho");
        System.out.println("register user info:"+user);
        boolean result=userService.processRegister(user);

        if(result) {
            model.addAttribute("resgisterResult","sucess");
            return "login.html";
        }else{
            model.addAttribute("resgisterResult","fail");
            return "register.html";
        }
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