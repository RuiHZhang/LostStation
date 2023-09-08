package com.zrh.controller;

import com.zrh.dao.TypeDao;
import com.zrh.pojo.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeDao typeDao;

    @GetMapping("/getAllTypes")
    @ResponseBody
    //获取所有的类型值
    public BaseResp getAllTypes(){
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setData(typeDao.getAllTypes());
        return baseResp;
    }
}
