package com.oracle.sb.service;

import com.oracle.sb.dao.UserDAO;
import com.oracle.sb.model.User;
import com.oracle.sb.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserServiceImp implements  UserService {

    @Autowired
    private UserDAO  userDAO;



    @Override
    public User processLogin(User user) {

        //对表单上提交过来的用户密码做加密操作
        //数据库密码加密时采用了加盐操作，加盐策略是在取用户名的开头字符和最后字符组合密码生成最终的加密密码

        String storedPassword=user.getUsername().substring(0,1)+user.getPassword()+user.getUsername().substring(user.getUsername().length()-2,user.getUsername().length());;


        System.out.println(storedPassword);
        user.setPassword(MD5Util.MD5(storedPassword));
        User u=userDAO.login(user);
        System.out.println("serive:加密"+user.getPassword());
        return u;
    }

    @Override
    public Boolean processRegister(User user) {
        System.out.println(userDAO);

        String storedPassword=user.getUsername().substring(0,1)+user.getPassword()+user.getUsername().substring(user.getUsername().length()-2,user.getUsername().length());

        user.setPassword(MD5Util.MD5(storedPassword));

        return userDAO.register(user);
    }
}
