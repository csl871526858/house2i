package com.team.house2backapi.service;

import com.team.house2backapi.entity.Users;

public interface UsersService{
    //注册
    public int regUser(Users users);
    //登入
    public Users Login(String username,String password);


}
