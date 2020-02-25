package com.yyd.intelligentwastebin.controller;

import com.yyd.intelligentwastebin.utils.ImageUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
/**
 * @author yangyidong
 * @version 1.0
 * @created 2020/2/16
 */
@CrossOrigin("*")
@RestController
public class ImageController {

    @PostMapping("/identpicture")
    public ResponseEntity identpicture(MultipartFile image){
        String map = ImageUtil.identpicture(image);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",map);
        return ResponseEntity.ok(result);

    }
    @PostMapping("/getLocation")
    public ResponseEntity getLocation(MultipartFile image){
        String map = ImageUtil.getLocation(image);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",map);
        return ResponseEntity.ok(result);

    }
}
