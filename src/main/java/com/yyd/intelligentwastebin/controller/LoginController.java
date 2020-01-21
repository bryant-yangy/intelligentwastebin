package com.yyd.intelligentwastebin.controller;

import com.yyd.intelligentwastebin.Service.AdminService;
import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.Admin;
import com.yyd.intelligentwastebin.domain.User;
import com.yyd.intelligentwastebin.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin("*")
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @PostMapping("/userlogin")
    public ResponseEntity<Map> userLogin(String username,String password){
        System.out.println(username);
        System.out.println(password);
        HashMap<String, Object> result = new HashMap<>();

        User serviceByName = userService.findByName(username);
        if(serviceByName==null){
            result.put("code",-1);
            result.put("data","用户名不存在");
            return ResponseEntity.ok(result);
        }
        if(!serviceByName.getPassword().equals(Md5Util.md5(password))){
            result.put("code",-1);
            result.put("data","密码错误");
            return ResponseEntity.ok(result);
        }

        result.put("code",0);
        result.put("data",serviceByName);
        return ResponseEntity.ok(result);
    }
    @RequestMapping ("/adminlogin")
    public ResponseEntity<Map> adminLogin(String username,String password){
        HashMap<String, Object> result = new HashMap<>();
        Admin serviceByName = adminService.findByName(username);
        if(serviceByName==null){
            result.put("code",-1);
            result.put("data","用户名不存在");
            return ResponseEntity.ok(result);
        }
        if(!serviceByName.getPassword().equals(Md5Util.md5(password))){
            result.put("code",-1);
            result.put("data","密码错误");
            return ResponseEntity.ok(result);
        }
        result.put("status",0);
        result.put("data",serviceByName);
        return ResponseEntity.ok(result);
    }
}
