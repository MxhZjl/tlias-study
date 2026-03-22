package com.example.controller;

import cn.hutool.core.io.IoUtil;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    /*@RequestMapping("/list")
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
     */
    //第一种方法，基于属性注入
    @Autowired//应用程序运行时，会自动的查询该类型的bean对象，并赋值给成员变量
    private UserService userService;
    //第二种方法：基于构造方法注入
//    private final UserService userService;
   // @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
    //第三种方法：基于setter方法注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    /*常用的是属性和构造方法注入，因为第三个方法如果属性值过多会显得很麻烦
    如果企业要求要规范一点，就选择构造函数注入，如果企业要求以速度为主，速度为王，快速开发
    那么则选择第一个属性注入，只需要一行代码就可以轻松地搞定将IOC容器当中的bean对象赋值给成员变量
    */
    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        //1.调用service层获取数据
        List<User> userList=userService.findAll();
        return userList;
    }
}
/**
 * 1.@Controller：表示当前类是一个控制器类
 * 3.@Service：表示当前类是一个服务类
 * 4.@Repository：表示当前类是一个数据访问类（dao）
 * 5.@Component：表示当前类是一个组件类
 * 前面三个是5的衍生注解，@Controller、@Service、@Repository
 */
/**
 * 如果bean对象不是单一的一个，使用@Autowired注解会报错
 * 此时解决方法有三个
 * 1.使用@Qualifier("bean的id")前面要加上@Autowired
 * 2.使用@Primary，放在要用的类的上面
 * 3.使用@Resource，放在要依赖注解的属性上面，不需要加@Autowired就可以实现和@Qualifier一样的效果
 */
