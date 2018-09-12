package com.oracle.sb.service;
import  com.oracle.sb.model.User;
public interface UserService {

    public User processLogin(User user);

    public Boolean  processRegister(User user);
}
