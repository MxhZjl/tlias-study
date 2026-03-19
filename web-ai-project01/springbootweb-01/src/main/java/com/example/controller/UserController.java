package com.example.controller;

import cn.hutool.core.io.IoUtil;
import com.example.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController//用户信息的controller,
public class UserController {
    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        //1.加载并读取user.txt文件
        //InputStream in = new FileInputStream(new File("D:\\web\\tlias-study\\web-ai-project01\\springbootweb-01\\src\\main\\resources\\user.txt"));
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines=IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        //2.解析用户信息，封装成User对象 ->list集合
        List<User> userList=lines.stream().map(line -> {
            String[] split = line.split(",");
           Integer id = Integer.parseInt(split[0]);
           String username = split[1];
           String password = split[2];
           String name = split[3];
           Integer age = Integer.parseInt(split[4]);
           LocalDateTime updateTime = LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
           return new User(id,username,password,name,age,updateTime);

        }).toList();
        //3.返回数据
        return userList;
    }
}
