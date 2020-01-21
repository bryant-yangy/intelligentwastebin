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
//        User user = new User(0, new Date(), "zhangsann", Md5Util.md5("123456"),"false", 0);
//        userService.addUser(user);
//        System.out.println(user.getId());
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
