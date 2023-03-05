package com.hyders.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyders.persistence.model.user.User;
import com.hyders.persistence.services.UserService;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PersistenceUnitTest {


    @Spy
    @InjectMocks
    UserService userService = new UserService();


    @Before
    public void setupTestData(){

        List<User> userList = new ArrayList<>();

        User user1 =new User();
        user1.setIp("192.168.18.7");
        user1.setTimestamp(new Date());
        user1.setUserId(1);
        user1.setUserAgent("Google Chrome");

        User user2 =new User();
        user2.setIp("192.168.18.5");
        user2.setTimestamp(new Date());
        user2.setUserId(2);
        user2.setUserAgent("Google Chrome");

        User user3 =new User();
        user3.setIp("192.168.18.9");
        user3.setTimestamp(new Date());
        user3.setUserId(3);
        user3.setUserAgent("Google Chrome");


        userList.addAll(Arrays.asList(user1,user2,user3));

        when(userService.findAll()).thenReturn(userList);

        User cloneUser = new User ();


        cloneUser.setUserAgent(user2.getUserAgent());
        cloneUser.setUserId(user2.getUserId());
        cloneUser.setTimestamp(user2.getTimestamp());
        cloneUser.setIp(user2.getIp());


        when (userService.findOne(2)).thenReturn(cloneUser);
        user2.setUserAgent("Safari");
        when (userService.update(user2)).thenReturn(user2);

    }


    @Test
    public void getAllUsers(){

        Assert.assertEquals(3,userService.findAll().size());

    }


    @Test
    public void updateAUser(){

        User user2 = userService.findOne(2);
        Assert.assertEquals("Google Chrome",user2.getUserAgent());
        Assert.assertEquals("Safari",userService.update(user2).getUserAgent());



    }


}
