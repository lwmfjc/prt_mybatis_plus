package com.baomidou.mybatisplus.samples.quickstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.samples.quickstart.entity.MyClass;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyClassMapper extends BaseMapper<MyClass> {
}