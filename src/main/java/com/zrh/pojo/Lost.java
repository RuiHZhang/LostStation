package com.zrh.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class Lost {
    //失物信息
    private int lostid;
    private String lostname;
    private String lostimg;
    private String lostdesc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date losttime;

    private Type losttype;
    private User lostuser;
    private Status loststatus;
    private Review lostreview;

    public Lost(String lostname, String lostimg, String lostdesc, Date losttime, Type losttype, User lostuser, Status loststatus,Review lostreview) {
        this.lostname = lostname;
        this.lostimg = lostimg;
        this.lostdesc = lostdesc;
        this.losttime = losttime;
        this.losttype = losttype;
        this.lostuser = lostuser;
        this.loststatus = loststatus;
        this.lostreview = lostreview;
    }
}
