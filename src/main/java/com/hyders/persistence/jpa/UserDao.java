package com.hyders.persistence.jpa;

import com.hyders.persistence.model.user.User;
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
