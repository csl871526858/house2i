package com.team.house2backapi.mapper;

import com.team.house2backapi.entity.House;
import com.team.house2backapi.entity.HouseExample;
import com.team.house2backapi.util.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询某用户下的所有出租房
    List<House> getHouseByUser(Integer userid);

    //浏览出租房
    List<House> browserHouse(HouseCondition houseCondition);
}