package com.zrh.dao;

import com.zrh.pojo.Status;

import java.util.List;

public interface StatusDao {
    //获取所有状态的方法
    List<Status> getAllStatus();

    //根据id获取状态的方法
    Status getStatusById(String statusid);
}
