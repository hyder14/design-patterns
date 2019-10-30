package com.hyders.persistence;


import com.hyders.persistence.jpa.UserDao;
import com.hyders.persistence.model.User.User;
import com.hyders.persistence.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfigTest.class }, loader = AnnotationConfigContextLoader.class)
public class PersistenceIntegrationTest {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserService userService;


    @Test
    @Transactional
    public void createUserTest() {

//        Session session = sessionFactory.getCurrentSession();
        int prevcount = userService.findAll().size();
        User testUser = new User();
        testUser.setUserId(300);
        testUser.setIp("192.168.157.1");
        testUser.setTimestamp(new Date());

        userService.create(testUser);

        Assert.assertTrue (userService.findAll().size() == prevcount + 1);


    }



}
