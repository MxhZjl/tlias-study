package com.example.springbootwebquickstart;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResposeController {
    //基于HttpServletResponse对象
    @RequestMapping("/respose")
    public void respose(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        //response.setStatus(200);//通常状态码不用自己设定，因为浏服务器端处理完之后会自己返回相应的状态码
        //2.设置响应头
        response.setHeader("name", "itheima");
        //3.设置响应体
        response.getWriter().write("hello world");
    }
    //基于ResponseEntity对象,是springboot提供的
    @RequestMapping("/respose2")
    public ResponseEntity<String> respose2() {
        return ResponseEntity.status(200).header("Project-Status","Building-Scrap-System")
                .body("hello world");
    }
}
