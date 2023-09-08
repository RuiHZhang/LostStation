package com.zrh.dao;

import com.zrh.pojo.Lost;

import java.util.List;

public interface LostDao {
    //获取所有失物信息的方法
    List<Lost> getAllLosts();

    //根据id获取丢失物品信息的方法
    Lost getLostById(int lostid);

    //获取所有失物条数的方法
    Long getTotalCount();

    //动态查询符合条件的数据
    List<Lost> dynamicGetLosts(String typeid,String statusid);

    //插入丢失物品信息(发布丢失物品信息)
    int postLost(Lost lost);

    //根据丢失物品id更新丢失物品的状态status为已经找到
    int updateLostStatus(int lostid);

    List<Lost> getLostsByUserId(int userid);
}
