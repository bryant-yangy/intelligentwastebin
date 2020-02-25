package com.yyd.intelligentwastebin.controller;


import com.yyd.intelligentwastebin.Service.TrashService;
import com.yyd.intelligentwastebin.domain.Product;
import com.yyd.intelligentwastebin.domain.Trash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author yangyidong
 * @version 1.0
 * @created 2020/2/16
 */
@CrossOrigin("*")
@RestController
public class TrashController {
    @Autowired
    TrashService trashService;

    @RequestMapping("/getTrashList")
    public ResponseEntity getTrashList() {
        List<Trash> list = trashService.findAll();
        HashMap<String, Object> result = new HashMap<>();
        result.put("data",list);
        result.put("code",0);
        return ResponseEntity.ok(result);
    }
}