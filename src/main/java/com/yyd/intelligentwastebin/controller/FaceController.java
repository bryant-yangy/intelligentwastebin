package com.yyd.intelligentwastebin.controller;


import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.User;
import com.yyd.intelligentwastebin.utils.Base64Util;
import com.yyd.intelligentwastebin.utils.FaceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * @author yangyidong
 * @version 1.0
 * @created 2020/2/16
 */
@CrossOrigin("*")
@RestController
public class FaceController {

    @Autowired
    UserService userService;
    @PostMapping("/isFace")
    public ResponseEntity<Map> isFace(MultipartFile image) throws IOException {
        byte[] imgData = image.getBytes();
        String encode = Base64Util.encode(imgData);
        boolean b = FaceUtil.isFace(encode);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",b);
        return ResponseEntity.ok(result);

    }

    @PostMapping("/identUser")
    public ResponseEntity<Map> identUser(MultipartFile image) throws IOException {
        int id = FaceUtil.identUser(image);
        HashMap<String, Object> result = new HashMap<>();
        if(id==0){
            result.put("code",-1);
            result.put("data","未识别出人脸");
            return ResponseEntity.ok(result);

        }
        if(id==-1){
            result.put("code",-1);
            result.put("data","识别度不高");
            return ResponseEntity.ok(result);
        }
        User user = userService.findById(id);
        result.put("code",0);
        result.put("data",user);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/addFace")
    public ResponseEntity<Map> addDace(String username,MultipartFile image){
        User user = userService.findByName(username);
        HashMap<String, Object> result = new HashMap<>();
        if(user==null){
            result.put("code",-1);
            result.put("data", "用户不存在");
            return ResponseEntity.ok(result);
        }
        HashMap hashMap = FaceUtil.addFace(user, image);
        if(hashMap==null){
            result.put("code",-1);
            result.put("data", "出现异常");
            return ResponseEntity.ok(result);
        }
        if(hashMap.get("error_msg").equals("SUCCESS")){
            userService.insertFace(user.getId());
            result.put("code",0);
            result.put("data","ok");
            return ResponseEntity.ok(result);

        }
        result.put("code",-1);
        result.put("data",(String) hashMap.get("error_msg"));
        return ResponseEntity.ok(result);
    }
    @RequestMapping("/getFaceList")
    public ResponseEntity<Map> getFaceList(){
        String list = FaceUtil.getFaceList();
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",list);
        return ResponseEntity.ok(result);
    }

}
