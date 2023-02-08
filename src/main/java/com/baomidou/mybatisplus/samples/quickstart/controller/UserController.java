package com.baomidou.mybatisplus.samples.quickstart.controller;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll(){
        List<User> list = userService.list();
        return list;
    }

    @RequestMapping("transactionTest")
    public List<User> transactionTest() throws Exception {
        List<User> list = userService.list();
        userService.removeByIds(list);

        return  userService.list();
    }
}
