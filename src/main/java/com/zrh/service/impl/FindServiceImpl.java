package com.zrh.service.impl;

import com.github.pagehelper.PageHelper;
import com.zrh.dao.FindDao;
import com.zrh.pojo.Find;
import com.zrh.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindServiceImpl implements FindService {
    @Autowired
    private FindDao findDao;

    @Override
    public List<Find> getAllFinds() {
        return findDao.getAllFinds();
    }

    @Override
    public Find getFindById(int findid) {
        return findDao.getFindById(findid);
    }

    @Override
    public List<Find> getFindsByPage(int cp, int ps) {
        PageHelper.startPage(cp,ps);
        return findDao.getAllFinds();
    }

    @Override
    public Long getTotalCount() {
        return findDao.getTotalCount();
    }
}
