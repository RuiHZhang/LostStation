package com.zrh.controller;

import com.zrh.dao.GradeDao;
import com.zrh.dao.LocationDao;
import com.zrh.pojo.Grade;
import com.zrh.pojo.Location;
import com.zrh.pojo.User;
import com.zrh.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GradeDao gradeDao;
    @Autowired
    private LocationDao locationDao;

    @GetMapping("/goLogin")
//    只是跳转到login.jsp界面
    public String goLogin(){
        return "user/login";
    }

    @GetMapping("/goMain")
    //只是跳转到main页面
    public String goMain(){
        return "main";
    }

    @PostMapping("/login")
//    用户登录方法
    public ModelAndView login(HttpServletRequest request){
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");

        User user = userService.login(username, userpass);
//        登录成功设置session然后跳转到main页面，否则跳转到注册页面
        if(user != null){
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
        else return new ModelAndView("user/register");
    }

    @GetMapping("/exitLogin")
    //用户主页面退出登录
    public String exitLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        session.removeAttribute("user");
        return "main";
    }

    @GetMapping("/goRegister")
    //只是跳转到注册页面
    public String goRegister(){
        return "/user/register";
    }

    @PostMapping("/register")
    //用户注册方法
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String usertel = request.getParameter("usertel");
        String usergender = request.getParameter("usergender");
        String usergrade = request.getParameter("usergrade");//这里获取的是usergrade的外键 对应的是gradeid
        Grade grade = gradeDao.getGradeById(usergrade);
        String userlocation = request.getParameter("userlocation");//这里获取的是userlocation的外键 对应的是locationid
        Location location = locationDao.getLocationById(userlocation);
        User user = new User(username, userpass, usergender,usertel,  grade, location);

        boolean register = userService.register(user);
        //注册成功后跳转到登录页面，否则跳转回注册页面
        if(register){
            return "user/login";
        }
        return "user/register";
    }

    @GetMapping("/goUserDetail")
    //根据id获取用户信息展示到用户详情页面
    public String goUserDetail(){
        return "user/userDetail";
    }

    @GetMapping("/goUserDetailChild")
    //到用户细节子页
    public String goUserDetailChild(){
        return "/user/userDetailChild";
    }

    @GetMapping("/goUpdateUser")
    //只是跳转到updateUser界面
    public String goUpdateUser(){
        return "user/updateUser";
    }

    @PostMapping("/updateUser")
    //更新用户信息，包含头像信息
    public String updateUser(HttpServletRequest request, MultipartFile userimg,HttpSession session){
        String filename = userimg.getOriginalFilename();
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String usertel = request.getParameter("usertel");
        String usergender = request.getParameter("usergender");
        String usergrade = request.getParameter("usergrade");//这里获取的是usergrade的外键 对应的是gradeid
        Grade grade = gradeDao.getGradeById(usergrade);
        String userlocation = request.getParameter("userlocation");//这里获取的是userlocation的外键 对应的是locationid
        Location location = locationDao.getLocationById(userlocation);
        User user = new User(userid,username, userpass, usergender, filename, usertel, grade, location);

        //数据库信息更新
        boolean b = userService.updateUser(user);
        if(b){
            //获得文件上传的路径
            String real_path = session.getServletContext().getRealPath("/image/user");
            File file = new File(real_path);
            //如果没有路径则创建一个
            if(!file.exists()){
                file.mkdirs();
            }
            //将文件上传到磁盘路径中，用户头像都在/image/user/路径下
            try {
                userimg.transferTo(new File(real_path+"\\"+filename));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //头像上传成功后需要修改session中的User，确保页面实时更新
            session.setAttribute("user",user);

            //文件上传成功后继续返回到用户详情页面
            return "user/userDetail";
        }
        return null;
    }

    @GetMapping("/userNameIsExist")
    @ResponseBody
    //判断用户名是否存在的方法
    public String userNameIsExist(@Param("username") String username){
        try {
            username = new String(username.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(username);
        List<String> allUserName = userService.getAllUserName();
        if(allUserName.contains(username)){
            return "true";
        }
        return "false";
    }
}
