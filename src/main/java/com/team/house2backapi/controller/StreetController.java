package com.team.house2backapi.controller;

import com.team.house2backapi.entity.District;
import com.team.house2backapi.entity.Street;
import com.team.house2backapi.service.DistrictService;
import com.team.house2backapi.service.StreetService;
import com.team.house2backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street/")
public class StreetController {
    @Autowired(required = false)
    private StreetService  streetService;
    //请求接收区域编号查询相应的街道
    @RequestMapping("getStreetData")
    public BaseResult getStreetData(Integer did){
        List<Street> list=streetService.getStreetByDid(did);
        return new BaseResult(200,list);
    }
}
