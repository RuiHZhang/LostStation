package com.zrh.controller;

import com.zrh.dao.LocationDao;
import com.zrh.pojo.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationDao locationDao;

    @GetMapping("/getAllLocations")
    @ResponseBody
    public BaseResp getAllLocations(){
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setData(locationDao.getAllLocations());
        return baseResp;
    }
}
