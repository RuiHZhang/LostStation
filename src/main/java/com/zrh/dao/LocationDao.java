package com.zrh.dao;

import com.zrh.pojo.Location;

import java.util.List;

public interface LocationDao {
    //根据id获取校区
    Location getLocationById(String locationid);

    //获取所有校区
    List<Location> getAllLocations();
}
