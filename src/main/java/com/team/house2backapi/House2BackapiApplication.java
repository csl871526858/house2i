package com.team.house2backapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//扫描mapper
@MapperScan("com.team.house2backapi.mapper")
//扫描过滤器
@ServletComponentScan("com.team.house2backapi.filter")
public class House2BackapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(House2BackapiApplication.class, args);
    }

}
