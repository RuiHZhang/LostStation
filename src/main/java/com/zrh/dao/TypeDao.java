package com.zrh.dao;

import com.zrh.pojo.Type;

import java.util.List;

public interface TypeDao {
    //获取所有类型的方法
    List<Type> getAllTypes();

    //根据id获取类型的方法
    Type getTypeById(String typeid);
}
