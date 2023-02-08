package com.baomidou.mybatisplus.samples.quickstart.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Transactional(
            rollbackFor = Exception.class
            ,propagation = Propagation.MANDATORY
    )
    @Override
    public void methodInner() throws Exception {
        System.out.println("我进来啦");
        //新增一条记录
        User user = new User();
        user.setName("outer_name");
        this.saveOrUpdate(user);
        //抛出异常
        //throw new Exception("hello");
    }
}


