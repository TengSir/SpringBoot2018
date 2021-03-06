package com.oracle.sb.dao;
import com.oracle.sb.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDAO {

    @Select("select * from user where username=#{username} and password=#{password}")
    public  User  login(User user);

    @Insert("insert into  user(userid,username,password) values(null,#{username},#{password})")
    public boolean  register(User user);
}
