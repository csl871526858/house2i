package com.team.house2backapi.service;

import com.team.house2backapi.entity.Street;

import java.util.List;

public interface StreetService {
    //通过区域查询街道
    public List<Street> getStreetByDid(Integer did);
}