package com.zrh.controller;

import com.zrh.pojo.BaseResp;
import com.zrh.pojo.Find;
import com.zrh.pojo.PageBean;
import com.zrh.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/find")
public class FindController {
    @Autowired
    private FindService findService;
    private String findimg; //

    @GetMapping("/showPartFinds")
    //展示部分失物招领信息方法
    public ModelAndView getAllFinds(){
        List<Find> finds = findService.getAllFinds();
        ModelAndView modelAndView = new ModelAndView("find/findStation", "finds", finds);
        return modelAndView;
    }

    @GetMapping("/getFindById/{findid}")
    //根据id获取失物招领信息并展示到详情页面
    public ModelAndView getFindById(@PathVariable("findid") int findid){
        Find find = findService.getFindById(findid);
        ModelAndView modelAndView = new ModelAndView("find/findDetail", "find", find);
        return modelAndView;
    }

    @GetMapping("/getFindsByPage")
    //分页获取失物招领信息并分页展示
    public ModelAndView getFindsByPage(@RequestParam(defaultValue = "1") int cp, @RequestParam(defaultValue = "5") int ps){
        List<Find> finds = findService.getFindsByPage(cp, ps);
        Long totalCount = findService.getTotalCount();
        PageBean<Find> pageBean = new PageBean<>(cp, ps, totalCount, finds);
        return new ModelAndView("find/allFinds","pageBean",pageBean);
    }

    @GetMapping("/goPostFind")
    //只是跳转到postFind界面
    public String goPostFind(){
        return "/find/postFind";
    }

    @PostMapping("/fileUpLoad")
    //用户实现拖曳上传，返回指定格式的响应数据，将其展示在页面上，同时将图片存到本地
    @ResponseBody
    public BaseResp fileUpLoad(MultipartFile file, HttpSession session){
        findimg = file.getOriginalFilename();   //上传的文件名字
        //获得文件上传的路径
        String real_path = session.getServletContext().getRealPath("/image/find");
        File localFile = new File(real_path);
        //如果没有路径则创建一个
        if(!localFile.exists()){
            localFile.mkdirs();
        }
        try {
            file.transferTo(new File(real_path+"\\"+findimg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setFile("/image/find/"+findimg);  //返回图片存放的路径，用户响应式展示
        return baseResp;
    }






}
