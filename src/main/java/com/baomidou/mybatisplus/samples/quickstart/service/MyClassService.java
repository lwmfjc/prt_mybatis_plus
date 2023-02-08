package com.baomidou.mybatisplus.samples.quickstart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.samples.quickstart.entity.MyClass;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;

public interface MyClassService extends IService<MyClass> {
    void methodOuter() throws Exception;

}


