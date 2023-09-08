package com.zrh.service.impl;

import com.github.pagehelper.PageHelper;
import com.zrh.dao.LostDao;
import com.zrh.pojo.Lost;
import com.zrh.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostServiceImpl implements LostService {
    @Autowired
    private LostDao lostDao;
    @Override
    public List<Lost> getAllLosts() {
        return lostDao.getAllLosts();
    }

    @Override
    public Lost getLostById(int lostid) {
        return lostDao.getLostById(lostid);
    }

    @Override
    public List<Lost> getLostsByPage(int cp, int ps) {
        PageHelper.startPage(cp,ps);
        List<Lost> losts = lostDao.getAllLosts();
        return losts;
    }

    @Override
    public Long getTotalCount() {
        return lostDao.getTotalCount();
    }

    @Override
    public List<Lost> dynamicGetLosts(String typeid, String statusid) {
        return lostDao.dynamicGetLosts(typeid,statusid);
    }

    @Override
    public boolean postLost(Lost lost) {
        return lostDao.postLost(lost) > 0;
    }

    @Override
    public boolean updateLostStatus(int lostid) {
        return lostDao.updateLostStatus(lostid) > 0;
    }

    @Override
    public List<Lost> getLostsByUserId(int userid) {
        return lostDao.getLostsByUserId(userid);
    }
}
