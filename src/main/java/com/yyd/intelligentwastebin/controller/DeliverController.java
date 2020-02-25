package com.yyd.intelligentwastebin.controller;

import com.yyd.intelligentwastebin.Service.DeliverService;
import com.yyd.intelligentwastebin.Service.TrashService;
import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.Deliver;
import com.yyd.intelligentwastebin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author yangyidong
 * @version 1.0
 * @created 2020/2/16
 */
@CrossOrigin("*")
@RestController
public class DeliverController {
    @Autowired
    DeliverService deliverService;
    @Autowired
    UserService userService;
    @Autowired
    TrashService trashService;

    @RequestMapping("/deliver")
    public ResponseEntity<Map> deliver(int userId,String trash) {
        HashMap<String, Object> result = new HashMap<>();
        User user = userService.findById(userId);
        if(user==null){
            result.put("code",-1);
            result.put("data","用户不存在");
            return ResponseEntity.ok(result);
        }
        int point = trashService.getPoint(trash);
        Deliver deliver = new Deliver(user.getName(),user.getUsername(), trash,point, new Date());
        deliverService.insert(deliver);
        result.put("code",0);
        result.put("data","Ok");
        return ResponseEntity.ok(result);
    }
    @RequestMapping("/getDeliverList")
    public ResponseEntity<Map> getDeliverList(){
        HashMap<String, Object> result = new HashMap<>();
        List<Deliver> all = deliverService.findAll();
        result.put("code",0);
        result.put("data",all);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/getDeliverPage")
    public ResponseEntity<Map> getDeliverPage(int page,int limit){
        HashMap<String, Object> result = new HashMap<>();
        List<Deliver> all = deliverService.findDeliverPage(page,limit);
        result.put("code",0);
        result.put("data",all);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/getDeliverCount")
    public ResponseEntity<Map> getDeliverCount(){
        HashMap<String, Object> result = new HashMap<>();
        int count = deliverService.getCount();
        result.put("code",0);
        result.put("data",count);
        return ResponseEntity.ok(result);
    }

}
