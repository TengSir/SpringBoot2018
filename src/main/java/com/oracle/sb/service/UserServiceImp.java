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
        user.setPassword(MD5Util.MD5(user.getPassword()));
        User u=userDAO.login(user);
        System.out.println("serive:加密"+user.getPassword());
        return u;
    }

    @Override
    public Boolean processRegister(User user) {
        System.out.println(userDAO);
        return true;
    }
}
