package com.example.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.example.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@Repository("userDao")
public class UserDaoimpl implements UserDao {
    @Override
    public List<String> findAll() {
        //1.加载并读取user.txt文件
        //InputStream in = new FileInputStream(new File("D:\\web\\tlias-study\\web-ai-project01\\springbootweb-01\\src\\main\\resources\\user.txt"));
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines=IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
