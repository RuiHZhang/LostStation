package com.zrh.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Find {
    //失物信息
    private int findid;
    private String findname;
    private String findimg;
    private String finddesc;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date findtime;

    private Type findtype;
    private User finduser;
    private Status findstatus;
}
