package com.team.house2backapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house2backapi.entity.House;
import com.team.house2backapi.entity.Users;
import com.team.house2backapi.service.HouseService;
import com.team.house2backapi.util.BaseResult;
import com.team.house2backapi.util.FileUploadUtil;
import com.team.house2backapi.util.HouseCondition;
import com.team.house2backapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/house/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    //发布出租房
  @RequestMapping("fabuHouse")
  public BaseResult fabuHouse(
          House house,   //接收输入的内容
          @RequestParam(value = "pfile",required = false)
                  MultipartFile pfile){
      try {
          //利用上传文件的工具类实现上传文件
          String path="d:\\images";
          String fileName=FileUploadUtil.upload(pfile,path);
          house.setId(System.currentTimeMillis()+"");
          //设置上传文件路径
          house.setPath(fileName);
          //调用业务保存信息
          houseService.addHouse(house);
          return new BaseResult(BaseResult.RESULT_SUCCESS,"");
      } catch (Exception e) {
          e.printStackTrace();
          return new BaseResult(BaseResult.RESULT_FAIL,"发布失败:"+e.getMessage());
      }
  }

    //获取用户出租房信息
    @RequestMapping("getHouseByPage")
    public BaseResult getHouseByPage(PageParmeter pageParmeter, HttpSession session){
        //调用业务获取分页信息
        Users users=(Users) session.getAttribute("logininfo");
        Integer userid=users.getId();   //获取session的用户编号
        PageInfo<House> pageInfo=this.houseService.getHouseByUser(userid,pageParmeter);
        //返回总页数
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("totalPage",pageInfo.getPages());  //总页数
        map.put("row",pageInfo.getList()); //当前页数据
        return new BaseResult(200,map);
    }

    //删除出租房
    @RequestMapping("delHouse")
    public BaseResult delHouse(String id){
        //调用业务获取分页信息  1表示删除
        int temp=this.houseService.deleteHouse(id,1);
        if(temp>0)
            return new BaseResult(BaseResult.RESULT_SUCCESS);
        else
            return new BaseResult(BaseResult.RESULT_FAIL);
    }

    //浏览出租房
    @RequestMapping("searchHouse")
    public BaseResult searchHouse(HouseCondition houseCondition){
        //调用业务获取分页信息  1表示删除
        PageInfo<House> pageInfo=this.houseService.getBroswerHouse(houseCondition);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("curPage",pageInfo.getPageNum());
        map.put("totalPage",pageInfo.getPages());
        map.put("list",pageInfo.getList());
        return new BaseResult(200,map);
    }
}
