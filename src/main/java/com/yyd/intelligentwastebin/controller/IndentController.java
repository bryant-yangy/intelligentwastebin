package com.yyd.intelligentwastebin.controller;

import com.yyd.intelligentwastebin.Service.IndentService;
import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.Indent;
import com.yyd.intelligentwastebin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author yangyidong
 * @version 1.0
 * @created 2020/2/16
 */
@CrossOrigin("*")
@Controller
public class IndentController {
    @Autowired
    IndentService indentService;
    @Autowired
    UserService userService;
    @RequestMapping("/getIdentListById")
    public ResponseEntity<Map> getIdentListById(int userId){
        HashMap<String, Object> result = new HashMap<>();
        User user = userService.findById(userId);
        if(user==null){
            result.put("code",-1);
            result.put("data","用户不存在");
            return ResponseEntity.ok(result);
        }
        List<Indent> list = indentService.findByUserName(user.getUsername());
        result.put("code",0);
        result.put("data",list);
        return ResponseEntity.ok(result);
    }
    @RequestMapping("/getIdentPage")
    public ResponseEntity<Map> getIdentList(int page,int limit){
        HashMap<String, Object> result = new HashMap<>();
        List<Indent> list = indentService.findIdentPage(page,limit);
        result.put("code",0);
        result.put("data",list);
        return ResponseEntity.ok(result);
    }
    @RequestMapping("/getIdentCount")
    public ResponseEntity<Map> getIdentCount(){
        HashMap<String, Object> result = new HashMap<>();
        int count  = indentService.getCount();
        result.put("code",0);
        result.put("data",count);
        return ResponseEntity.ok(result);
    }
}
