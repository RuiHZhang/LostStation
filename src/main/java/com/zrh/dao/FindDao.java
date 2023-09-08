package com.zrh.dao;

import com.zrh.pojo.Find;
import com.zrh.pojo.Lost;

import java.util.List;

public interface FindDao {
    //获取所有寻物信息的方法
    List<Find> getAllFinds();

    //根据id获取寻物信息的方法
    Find getFindById(int findid);

    //获取所有寻物条数的方法
    Long getTotalCount();
}
