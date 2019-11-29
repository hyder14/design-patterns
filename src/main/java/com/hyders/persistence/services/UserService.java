package com.hyders.persistence.services;

import com.hyders.persistence.jpa.UserDao;
import com.hyders.persistence.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    public UserService() {
        super();
        userDao = new UserDao();
    }

    public User findOne(long id) {
        userDao.openSessionWithTransaction();
        User user= userDao.findOne(id);
        userDao.closeSessionWithTransaction();
        return user;
    }

    public List<User> findAll() {
        userDao.openSessionWithTransaction();
        List<User> users = userDao.findAll();
        userDao.closeSessionWithTransaction();
        return users;
    }

    public User create(User user) {
        userDao.openSessionWithTransaction();
        User created =  userDao.create(user);
        userDao.closeSessionWithTransaction();
        return created;
    }

    public void delete(long id) {
        userDao.openSessionWithTransaction();
        userDao.deleteById(id);
        userDao.closeSessionWithTransaction();
    }

    public User update(User user) {
        userDao.openSessionWithTransaction();
        User modifieduser = userDao.update(user);
        userDao.closeSessionWithTransaction();
        return modifieduser;
    }

}
