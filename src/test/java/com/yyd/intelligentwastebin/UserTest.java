package com.yyd.intelligentwastebin;
import com.yyd.intelligentwastebin.Service.ProductService;
import com.yyd.intelligentwastebin.ServiceImpl.UserServiceImpl;
import com.yyd.intelligentwastebin.domain.Product;
import com.yyd.intelligentwastebin.domain.User;
import com.yyd.intelligentwastebin.mapper.UserMapper;
import com.yyd.intelligentwastebin.utils.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    UserServiceImpl userService ;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductService productService;
    @Test
    void adduser() {
        User user = new User(0, new Date(), "zhangsan", Md5Util.md5("123456"),"false", 1000,"12345678910","张三");
        userService.addUser(user);
        user = new User(0, new Date(), "lisi", Md5Util.md5("123456"),"false", 1000,"12345678910","李四");
        userService.addUser(user);
        user = new User(0, new Date(), "wangwu", Md5Util.md5("123456"),"false", 1000,"12345678910","王五");
        userService.addUser(user);
        user = new User(0, new Date(), "wangbatian", Md5Util.md5("123456"),"false", 1000,"12345678910","王霸天");
        userService.addUser(user);
        user = new User(0, new Date(), "zuofei", Md5Util.md5("123456"),"false", 2000,"12345678910","左飞");
        userService.addUser(user);
        user = new User(0, new Date(), "houzi", Md5Util.md5("123456"),"false", 10000,"12345678910","猴子");
        userService.addUser(user);
        user = new User(0, new Date(), "huangjie", Md5Util.md5("123456"),"false", 10000,"12345678910","黄杰");
        userService.addUser(user);
        user = new User(0, new Date(), "zhengwu", Md5Util.md5("123456"),"false", 10000,"12345678910","郑午");
        userService.addUser(user);
        user = new User(0, new Date(), "maomao", Md5Util.md5("123456"),"false", 10000,"12345678910","毛毛");
        userService.addUser(user);
        user = new User(0, new Date(), "zhurourong", Md5Util.md5("123456"),"false", 1000,"12345678910","猪肉荣");
        userService.addUser(user);
        user = new User(0, new Date(), "wangyao", Md5Util.md5("123456"),"false", 1000,"12345678910","王瑶");
        userService.addUser(user);
        user = new User(0, new Date(), "liuyina", Md5Util.md5("123456"),"false", 1000,"12345678910","柳伊娜");
        userService.addUser(user);
        user = new User(0, new Date(), "suyi", Md5Util.md5("123456"),"false", 10000,"12345678910","苏亦");
        userService.addUser(user);
        user = new User(0, new Date(), "damao", Md5Util.md5("123456"),"false", 10000,"12345678910","大猫");
        userService.addUser(user);
        user = new User(0, new Date(), "heizi", Md5Util.md5("123456"),"false", 1000,"12345678910","黑子");
        userService.addUser(user);
        System.out.println(user.getId());
    }
    @Test
    void isUserExit(){
        User zhangsan = userMapper.findByName("王越");
        System.out.println(zhangsan.getCreateDate());
        System.out.println(zhangsan.getUsername());

    }
    @Test
    void isFace() throws IOException {
        String filePath = "21.jpg";
        byte[] imgData = FileUtil.readFileByBytes(filePath);
        String imgStr = Base64Util.encode(imgData);
        System.out.println(FaceUtil.isFace(imgStr));
    }
    @Test
    void findById(){
        User user = userMapper.findById(1001);
        System.out.println(user.getName());
        System.out.println(user.getId());
        System.out.println(user.getCreateDate());
    }
    @Test
    void findByName(){
        User user = userMapper.findByName("wangyue");
        System.out.println(user.getId());
    }
    void insertFace(){

    }

    void updatePoints(){

    }
}
