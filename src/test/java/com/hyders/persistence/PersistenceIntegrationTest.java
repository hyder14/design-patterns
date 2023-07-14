package com.hyders.persistence;


import com.hyders.persistence.model.user.User;
import com.hyders.persistence.services.UserService;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(PersistenceIntegrationTest.class);


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

        logger.info("Creating user: " + testUser.toString());

        Assert.assertTrue (userService.findAll().size() == prevcount + 1);


    }



}
