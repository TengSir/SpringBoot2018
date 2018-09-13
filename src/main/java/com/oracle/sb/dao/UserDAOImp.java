package com.oracle.sb.dao;

import com.oracle.sb.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserDAOImp extends BaseDAO implements  UserDAO {

    @Override
    public User login(User user) {

        UserDAO dao=getSqlSessionFactory().openSession().getMapper(UserDAO.class);
        System.out.println("dao"+dao);
        return dao.login(user);
    }

    @Override
    public boolean register(User user)
    {
        UserDAO  dao=getSqlSessionFactory().openSession().getMapper(UserDAO.class);
        return dao.register(user);
    }
}
