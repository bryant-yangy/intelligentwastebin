package com.yyd.intelligentwastebin;

import com.yyd.intelligentwastebin.Service.AdminService;
import com.yyd.intelligentwastebin.domain.Admin;
import com.yyd.intelligentwastebin.utils.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminTest {
    @Autowired
    AdminService adminService;
    @Test
    public  void insert(){
        Admin admin = new Admin(0, "admin", Md5Util.md5("123"));
        adminService.insert(admin);
    }
    @Test
    public void Login(){
        Admin admin = adminService.findByName("admin");
        System.out.println(admin);
    }
}
