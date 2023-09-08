package com.zrh.service;

import com.zrh.pojo.Find;

import java.util.List;

public interface FindService {
    //获取所有lost失物信息方法
    List<Find> getAllFinds();

    //根据id获取丢失物品信息的方法
    Find getFindById(int findid);

    //根据分页获取部分丢失物品
    List<Find> getFindsByPage(int cp,int ps);

    //获取总条目数的方法
    Long getTotalCount();
}
