package com.oracle.sb.config;


import com.oracle.sb.dao.UserDAO;
import com.oracle.sb.dao.UserDAOImp;
import com.oracle.sb.service.UserService;
import com.oracle.sb.service.UserServiceImp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//在springboot并不是完全没有配置，他用这种java类方式配置替换掉了xml配置，配置集中化，
@SpringBootApplication
public class UserModuleConfig {

    //这是一个springboot的集中高配置类，他的意义是在于讲所有的组件管理和装配全部配置到这个类中(配置集中化，去xml化)


    //下面这个方法就相当于告诉springboot，由springboot帮我们管理UserService这个javaBean对象
    @Bean
    public UserService   getUserSerice(){
        return  new UserServiceImp();
    }
    @Bean
    public UserDAO  getUserDAO(){
        return new UserDAOImp();
    }

}
