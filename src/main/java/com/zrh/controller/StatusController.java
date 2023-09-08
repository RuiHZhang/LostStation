package com.zrh.controller;

import com.zrh.dao.StatusDao;
import com.zrh.pojo.BaseResp;
import com.zrh.pojo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusDao statusDao;

    @GetMapping("/getAllStatus")
    @ResponseBody
    public BaseResp getAllStatus(){
        List<Status> status = statusDao.getAllStatus();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setData(status);
        return baseResp;
    }
}
