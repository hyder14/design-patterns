package com.hyders.persistence;

import com.hyders.persistence.model.User.User;
import com.hyders.persistence.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Application {


    @Autowired
    private static UserService userService = new UserService();


    public static void main (String[] args) {

        int prevcount = userService.findAll().size();
//        User testUser = new User();
//        testUser.setUserId(700);
//        testUser.setIp("192.168.216.3");
//        testUser.setTimestamp(new Date());
//        testUser.setUserAgent("Chrome");
//
//        userService.create(testUser);

//        userService.findOne(10);

//        userService.delete(16);


        User userToModify = userService.findOne(18);

        userToModify.setUserId(900);
        userToModify.setUserAgent("IE");
        userService.update(userToModify);


    }




}
