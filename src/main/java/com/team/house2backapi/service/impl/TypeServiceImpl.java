package com.team.house2backapi.service.impl;

import com.team.house2backapi.entity.Type;
import com.team.house2backapi.entity.TypeExample;
import com.team.house2backapi.mapper.TypeMapper;
import com.team.house2backapi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;
    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
