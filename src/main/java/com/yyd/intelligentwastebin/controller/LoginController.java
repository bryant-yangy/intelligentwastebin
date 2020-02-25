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

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
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
    @RequestMapping ("/admin/login")
    public ResponseEntity<Map> adminLogin(String username, String password ,HttpSession session){
        HashMap<String, Object> result = new HashMap<>();
        Admin admin = adminService.findByName(username);
        if(admin==null){
            result.put("code",-1);
            result.put("data","用户名不存在");
            return ResponseEntity.ok(result);
        }
        if(!admin.getPassword().equals(Md5Util.md5(password))){
            result.put("code",-1);
            result.put("data","密码错误");
            return ResponseEntity.ok(result);
        }
        session.setAttribute("admin",admin);
        result.put("status",0);
        result.put("data",admin);
        return ResponseEntity.ok(result);
    }
    @RequestMapping ("/admin/getAdminInformation")
    public ResponseEntity<Map> getAdminInformation(HttpSession session){
        HashMap<String, Object> result = new HashMap<>();

        Admin admin = (Admin) session.getAttribute("admin");
        if(admin!=null){
            result.put("status",0);
            result.put("data",admin);
        }else {
            result.put("status",-1);
        }
        return ResponseEntity.ok(result);
    }
}
