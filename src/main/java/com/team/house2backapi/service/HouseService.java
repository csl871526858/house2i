package com.team.house2backapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house2backapi.entity.House;
import com.team.house2backapi.util.HouseCondition;
import com.team.house2backapi.util.PageParmeter;

public interface HouseService {
    //发布出租房
    public int addHouse(House house);

    //查询某用户下的出租房
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter);

    //删除出租房|恢复出租房
    public int deleteHouse(String id,Integer delState);

    //浏览出租房
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition);
}