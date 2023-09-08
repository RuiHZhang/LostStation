package com.zrh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userid;
    private String username;
    private String userpass;
    private String usergender;
    private String userimg;
    private String usertel;
    private Grade usergrade;
    private Location userlocation;

    public User(String username, String userpass, String usergender, String userimage, String usertel, Grade usergrade, Location userlocation) {
        this.username = username;
        this.userpass = userpass;
        this.usergender = usergender;
        this.userimg = userimage;
        this.usertel = usertel;
        this.usergrade = usergrade;
        this.userlocation = userlocation;
    }

    public User(String username, String userpass, String usergender, String usertel, Grade usergrade, Location userlocation) {
        this.username = username;
        this.userpass = userpass;
        this.usergender = usergender;
        this.usertel = usertel;
        this.usergrade = usergrade;
        this.userlocation = userlocation;
    }
}
