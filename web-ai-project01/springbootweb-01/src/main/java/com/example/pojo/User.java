package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;//在项目开发当中，对于基本类型，我们建议用包装类
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;

}
