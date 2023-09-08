package com.zrh.dao;

import com.zrh.pojo.Grade;

import java.util.List;

public interface GradeDao {
    //根据gradeid获取年级信息
    Grade getGradeById(String gradeid);

    //获取所有的年级数据
    List<Grade> getAllGrades();

    //根据
}
