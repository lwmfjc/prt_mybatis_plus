package com.baomidou.mybatisplus.samples.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.quickstart.entity.MyClass;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.MyClassMapper;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.service.MyClassService;
import com.baomidou.mybatisplus.samples.quickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyClassServiceImpl extends ServiceImpl<MyClassMapper, MyClass> implements MyClassService {
    @Autowired
    private UserService userService;

   /* @Transactional(
            rollbackFor = Exception.class
            ,propagation = Propagation.REQUIRED
    )*/
    @Override
    public void methodOuter() throws Exception {
        //新增一条记录
        MyClass myClass=new MyClass();
        myClass.setName("class_name");
        this.saveOrUpdate(myClass);

        //调用内方法
        userService.methodInner();
        //抛出异常
        //throw new Exception("hello");
    }
}


