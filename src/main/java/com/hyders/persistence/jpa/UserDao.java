package com.hyders.persistence.jpa;

import com.hyders.persistence.model.User.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
//@PropertySource("classpath:application-dev.properties")
public class UserDao extends AbstractJpaDAO<User> implements IUserDao {


    public UserDao()
    {
        super();
        setClazz(User.class);
    }



}
