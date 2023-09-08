package com.zrh.controller;

import com.zrh.dao.GradeDao;
import com.zrh.pojo.BaseResp;
import com.zrh.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeDao gradeDao;

    @GetMapping("/getAllGrades")
    @ResponseBody
    public BaseResp getAllGrades(){
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setData(gradeDao.getAllGrades());
        return baseResp;
    }

}
