package com.zrh.service;

import com.zrh.pojo.Lost;

import java.util.List;

public interface LostService {
    //获取所有lost失物信息方法
    List<Lost> getAllLosts();

    //根据id获取丢失物品信息的方法
    Lost getLostById(int lostid);

    //根据分页获取部分丢失物品
    List<Lost> getLostsByPage(int cp,int ps);

    //获取总条目数的方法
    Long getTotalCount();

    //丢失物品分页展示页面的动态查询
    List<Lost> dynamicGetLosts(String typeid,String statusid);

    //插入丢失物品信息的方法（发布丢失物品）
    boolean postLost(Lost lost);

    //根据lostid修改丢失物品状态为已经找到了
    boolean updateLostStatus(int lostid);

    //根据当前登录用户ID查询当前用户发布的所有丢失信息
    List<Lost> getLostsByUserId(int userid);
}
