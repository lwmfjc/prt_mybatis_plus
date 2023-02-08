package com.baomidou.mybatisplus.samples.quickstart.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Transactional(
            rollbackFor = Exception.class
            , propagation = Propagation.MANDATORY
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

    @Transactional(
            isolation = Isolation.READ_COMMITTED
    )
    public User isolation1() {
        //读取userid=1的值
        User byId = this.getById(1L);
        return byId;

    }

    @Transactional
    public User isolation2() throws InterruptedException {

        //10s后修改
        TimeUnit.SECONDS.sleep(10);
        User user=new User();
        user.setId(1L);
        user.setName("1被修改了");
        this.saveOrUpdate(user);
        //10s后提交
        TimeUnit.SECONDS.sleep(10);
        return null;
    }
}


