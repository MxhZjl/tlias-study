package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest { //测试类的命名规范，XXXXTest
    @Test
    public void testGetAge() {
        UserService userService=new UserService();
        Integer age=userService.getAge("100000200010011011");
        System.out.println(age);
    }
    @Test
    public void testGetGender() {
        UserService userService=new UserService();
        String gender = userService.getGender("100000200010011011");
        System.out.println();
    }
    /*
     * 基于断言
     */
    @Test
    //测试写的函数我们所期待的和输出的是否一样
    public void testGenderWithAssert(){
        UserService userService=new UserService();
        String gender = userService.getGender("100000200010011011");
        Assertions.assertEquals("男",gender);
    }
    @Test
    //测试写的函数抛出的异常是否如我们所要求的
    public void testGenderWithAssert2(){
        UserService userService=new UserService();
        String gender = userService.getGender("100000200010011011");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            userService.getGender(null);
        }); 

        



    }


}

