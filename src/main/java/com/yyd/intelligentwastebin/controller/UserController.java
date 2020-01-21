package com.yyd.intelligentwastebin.controller;

import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.User;
import com.yyd.intelligentwastebin.utils.Base64Util;
import com.yyd.intelligentwastebin.utils.FaceUtil;
import com.yyd.intelligentwastebin.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/userAdd")
    public ResponseEntity<Map> userAdd(User user, MultipartFile image) {
        user.setPassword(Md5Util.md5(user.getPassword()));
        user.setCreateDate(new Date());
        System.out.println(image.getSize());
        userService.addUser(user);
        HashMap hashMap = FaceUtil.addFace(user, image);
        HashMap<String, Object> result = new HashMap<>();
        if (hashMap == null) {
            result.put("code", -1);
            result.put("data", "出现异常");
            return ResponseEntity.ok(result);
        }
        if (hashMap.get("error_msg").equals("SUCCESS")) {
            userService.insertFace(user.getId());
            result.put("code", 0);
            result.put("data", "ok");
            return ResponseEntity.ok(result);
        }
        result.put("code", -1);
        result.put("data", (String) hashMap.get("error_msg"));
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/isNameExit")
    public ResponseEntity<Map> isNameExit(String username) {
        User user = userService.findByName(username);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        if (user == null) {
            result.put("data", "false");
            return ResponseEntity.ok(result);
        }
        result.put("data", true);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/getUserList")
    public ResponseEntity<Map> getUserList() {
        List<User> list = userService.findAll();
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", list);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/updatePoints")
    public ResponseEntity<Map> updatePoints(int UserId, int point) {
        HashMap<String, Object> result = new HashMap<>();
        User user = userService.findById(UserId);
        if (user == null) {
            result.put("code", -1);
            result.put("data", "用户不存在");
            return ResponseEntity.ok(result);
        }
        user.setPoints(point);
        userService.updatePoints(user);
        result.put("code", 0);
        result.put("data", "Ok");
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/getUserCount")
    public ResponseEntity<Map> getUSerCount() {
        HashMap<String, Object> result = new HashMap<>();
        int count = userService.getCount();
        result.put("code", 0);
        result.put("data", count);
        return ResponseEntity.ok(result);
    }
}
