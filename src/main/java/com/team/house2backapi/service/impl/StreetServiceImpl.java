package com.team.house2backapi.service.impl;

import com.team.house2backapi.entity.Street;
import com.team.house2backapi.entity.StreetExample;
import com.team.house2backapi.mapper.StreetMapper;
import com.team.house2backapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;
    @Override
    public List<Street> getStreetByDid(Integer did) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria=streetExample.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(streetExample);
    }
}
