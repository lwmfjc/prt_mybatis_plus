package com.baomidou.mybatisplus.samples.quickstart.controller;

import com.baomidou.mybatisplus.samples.quickstart.entity.MyClass;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.service.MyClassService;
import com.baomidou.mybatisplus.samples.quickstart.service.UserService;
import com.baomidou.mybatisplus.samples.quickstart.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MyClassService myClassService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("findAll")
    public List<User> findAll(){
        List<User> list = userService.list();
        return list;
    }

    @RequestMapping("transactionTest")
    public String transactionTest() throws Exception {
        //清空数据
        List<User> list = userService.list();
        userService.removeByIds(list);
        List<MyClass> myClasses = myClassService.list();
        myClassService.removeByIds(myClasses);

        //调用事务方法
        myClassService.methodOuter();

        return  userService.list().toString()+"\n"+myClassService.list().toString();
    }

    @RequestMapping("isolatoionTest1")
    public User isolationTest1(){
        return userServiceImpl.isolation1();
    }
    @RequestMapping("isolatoionTest2")
    public User isolationTest2() throws InterruptedException {
        return userServiceImpl.isolation2();
    }
}
