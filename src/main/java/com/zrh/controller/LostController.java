package com.zrh.controller;

import com.zrh.dao.ReviewDao;
import com.zrh.dao.StatusDao;
import com.zrh.dao.TypeDao;
import com.zrh.pojo.*;
import com.zrh.service.LostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lost")
public class LostController {
    @Autowired
    private LostService lostService;
    @Autowired
    private TypeDao typeDao;
    @Autowired
    private StatusDao statusDao;
    @Autowired
    private ReviewDao reviewDao;

    //因为layui拖曳上传表单提交时后端可以获取到MultipartFile file,
    // 但是file.getOriginalFilename()总是“”,所以全局设置这个属性,
    //在fileUpLoad方法中给它设置值，在postLost方法中使用
    private String lostimg = null;

    @GetMapping("/showPartLosts")
    //获取所有失物信息返回到main.jsp页面只展示一部分
    public ModelAndView showPartLosts(){
        List<Lost> allLosts = lostService.getAllLosts();
        ModelAndView modelAndView = new ModelAndView("lost/lostStation", "allLosts", allLosts);
        return modelAndView;
    }

    @GetMapping("/getLostById/{lostid}")
    //根据传到后端的id获取对应的丢失物品信息
    public ModelAndView getLostById(@PathVariable("lostid") int lostid){
        Lost lost = lostService.getLostById(lostid);
        ModelAndView modelAndView = new ModelAndView("/lost/lostDetail", "lost", lost);
        return modelAndView;
    }

    @GetMapping("/getLostsByPage")
    //分页获取丢失物品信息
    public ModelAndView getLostsByPage(@RequestParam(defaultValue = "1") int cp,@RequestParam(defaultValue = "5") int ps){
        List<Lost> allLosts = lostService.getLostsByPage(cp, ps);   //分页的部分数据
        Long totalCount = lostService.getTotalCount();  //lost表中的总条目数，用户分页控制器的遍历使用

        PageBean<Lost> pageBean = new PageBean<>(cp, ps,totalCount, allLosts);  //辅助分页的类PageBean

        ModelAndView modelAndView = new ModelAndView("lost/allLosts", "pageBean", pageBean);
        return modelAndView;
    }

    @PostMapping("/dynamicGetLosts")
    //动态查询
    public ModelAndView dynamicGetLosts(@Param("typeid") String typeid,@Param("statusid") String statusid){
        if("全部".equals(typeid) && "全部".equals(statusid)){
            ModelAndView modelAndView = getLostsByPage(1, 5);
            return modelAndView;
        }else if("全部".equals(typeid)){
            List<Lost> losts = lostService.dynamicGetLosts(null, statusid);
            PageBean<Lost> pageBean = new PageBean<>(1, 5, losts.size(), losts);
            ModelAndView modelAndView = new ModelAndView("lost/allLosts","pageBean",pageBean);
            return modelAndView;
        }else if("全部".equals(statusid)){
            List<Lost> losts = lostService.dynamicGetLosts(typeid, null);
            PageBean<Lost> pageBean = new PageBean<>(1, 5, losts.size(), losts);
            ModelAndView modelAndView = new ModelAndView("lost/allLosts","pageBean",pageBean);
            return modelAndView;
        }
        List<Lost> losts = lostService.dynamicGetLosts(typeid, statusid);
        PageBean<Lost> pageBean = new PageBean<>(1, 5, losts.size(), losts);
        ModelAndView modelAndView = new ModelAndView("lost/allLosts","pageBean",pageBean);
        return modelAndView;
    }

    @GetMapping("/goPostLost")
    //只是跳转到/lost/postLost.jsp页面
    public String goPostLost(){
        return "/lost/postLost";
    }

    @PostMapping("/postLost")
    //发布失物信息
    public ModelAndView postLost(HttpSession session, HttpServletRequest request){
        String lostname = request.getParameter("lostname");
        String lostdesc = request.getParameter("lostdesc");
        String slosttime = request.getParameter("losttime");    //得到时间的String，转为Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date losttime = null;
        try {
            losttime = format.parse(slosttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String losttype = request.getParameter("losttype"); //获取typeid并查到对应的type对象
        Type type = typeDao.getTypeById(losttype);
        User lostuser = (User) session.getAttribute("user");    //获取session中的user，就是当前用户
        String loststatus = request.getParameter("loststatus"); //获取statusid并查到对应的status对象
        Status status = statusDao.getStatusById(loststatus);

        Review lostreview = reviewDao.getReviewById(1); //根据id获取审核，1表示nopass,新发布丢失物品默认为nopass

        Lost lost = new Lost(lostname,lostimg,lostdesc,losttime,type,lostuser,status,lostreview);

        boolean b = lostService.postLost(lost); //调用service层进行丢失物品发布
        if(b){
            //插入成功跳转到allLosts分页展示页面,并将lostimg置空，防止影响其他
            lostimg = null;
            return getLostsByPage(1,5);
        }
        return null;
    }

    @PostMapping("/fileUpLoad")
    //用户实现拖曳上传，返回指定格式的响应数据，将其展示在页面上，同时将图片存到本地
    @ResponseBody
    public BaseResp fileUpLoad(MultipartFile file,HttpSession session){
        MultipartFile img = file;
        lostimg = file.getOriginalFilename();   //上传的文件名字
        //获得文件上传的路径
        String real_path = session.getServletContext().getRealPath("/image/lost");
        String back_path = "D:\\桌面文件\\Java千峰相关文件\\java2305\\阶段3\\exercise\\lostStationManage\\src\\main\\webapp\\image\\lost";

        File localFile = new File(real_path);
        //后台储存文件的地址
        File backFile = new File(back_path);

        //如果没有路径则创建一个
        if(!localFile.exists()){
            localFile.mkdirs();
        }
        if(!backFile.exists()){
            backFile.mkdirs();
        }
        try {
//            file.transferTo(new File(real_path+"\\"+lostimg));  //给前端存储地址存
//            file.transferTo(new File(backFile +"\\"+lostimg));    //给后端存储地址存
            //这个file文件不能重复使用查，重复使用会报错无
            inputStreamToFile(file.getInputStream(),new File(real_path+"\\"+lostimg));
            inputStreamToFile(file.getInputStream(),new File(backFile+"\\"+lostimg));
//            this.inputStreamToFile((FileInputStream) file.getInputStream(), new File(real_path+"\\"+lostimg));
//            this.inputStreamToFile((FileInputStream) file.getInputStream(), new File(backFile +"\\"+lostimg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setFile("/image/lost/"+lostimg);  //返回图片存放的路径，用户响应式展示
        return baseResp;
    }

    @GetMapping("/updateLostStatus")
    //根据lostid更新丢失物品状态为已经找到
    public ModelAndView updateLostStatus(@Param("lostid") int lostid){
        boolean b = lostService.updateLostStatus(lostid);
        if(b){
            return getLostsByPage(1,5);
        }
        return null;
    }

    @GetMapping("/getLostsByUserId")
    //根据用户id查当前登录用户所发布的丢失物品信息
    public ModelAndView getLostsByUserId(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Lost> losts = lostService.getLostsByUserId(user.getUserid());
        ModelAndView modelAndView = new ModelAndView("/user/userLosts", "losts", losts);
        return modelAndView;
    }

    //工具方法，用户将MultipartFile
    public void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
