package com.baomidou.mybatisplus.samples.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.quickstart.entity.MyClass;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.MyClassMapper;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.service.MyClassService;
import com.baomidou.mybatisplus.samples.quickstart.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class MyClassServiceImpl extends ServiceImpl<MyClassMapper, MyClass> implements MyClassService {


    @Override
    public void methodOuter() throws Exception {
        MyClass myClass=new MyClass();
        myClass.setName("class_name");
        this.saveOrUpdate(myClass);
    }
}


