package com.oracle.sb.dao;
import com.oracle.sb.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDAO {

    @Select("select * from user where username=#{username} and password=#{password}")
    public  User  login(User user);

    public boolean  register(User user);
}
