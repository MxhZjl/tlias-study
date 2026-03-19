package com.test;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RespeonseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        response.setStatus(200);
        //2.设置响应头
        response.setHeader("name", "itheima");
        //3.设置响应体
        response.getWriter().write("hello,response");
    }
}
