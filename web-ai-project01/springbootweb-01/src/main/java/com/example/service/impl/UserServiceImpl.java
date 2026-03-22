package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoimpl;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service//将当前类交给IOC容器管理
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        //1.调用dao来获取数据
        List<String> lines = userDao.findAll();
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
        return userList;
    }
}
