package com.team.house2backapi.service.impl;

import com.team.house2backapi.entity.Users;
import com.team.house2backapi.entity.UsersExample;
import com.team.house2backapi.mapper.UsersMapper;
import com.team.house2backapi.service.UsersService;
import com.team.house2backapi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public int regUser(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return  usersMapper.insertSelective(users);
    }

    @Override   //登入的密码加密后再进行数据库比对
    public Users Login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        //添加条件
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list!=null&&list.size()==1){
            return list.get(0);
        }
        else
        return null;
    }
}
