package com.yyd.intelligentwastebin.controller;

import com.yyd.intelligentwastebin.Service.IndentService;
import com.yyd.intelligentwastebin.Service.ProductService;
import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.Indent;
import com.yyd.intelligentwastebin.domain.Product;
import com.yyd.intelligentwastebin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.io.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    IndentService indentService;
    @RequestMapping("/productAdd")
    public ResponseEntity insert(Product product, MultipartFile picture, HttpServletRequest req){
        String realPath = req.getSession().getServletContext().getRealPath("/picture/");
        File folder = new File(realPath);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        String oldName = picture.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());

        HashMap<String, Object> result = new HashMap<>();
        try {
            // 文件保存
            picture.transferTo(new File(folder, newName));

            // 返回上传文件的访问路径
            String filePath = req.getScheme() + "://" + req.getServerName()
                    + ":" + req.getServerPort() + "/picture/" + newName;
            product.setImage(filePath);
            productService.insert(product);

            result.put("code",0);
            result.put("data","ok");
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code",-1);
            result.put("data","图片上传出错");
            return ResponseEntity.ok(result);
        }
    }
    @RequestMapping("/getProductList")
    public ResponseEntity findAll(){
        List<Product> list = productService.findAll();
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",list);
        return ResponseEntity.ok(result);
    }
    @RequestMapping("/purchaseProduct")
    public ResponseEntity purchaseProduct(int userId,int productId,int account){
        User user = userService.findById(userId);
        Product product = productService.findById(productId);
        HashMap<String, Object> result = new HashMap<>();
        if(product.getAccount()<account){
            result.put("code",-1);
            result.put("data","数量不足");
            return ResponseEntity.ok(result);
        }
        if(user.getPoints()<account*product.getPoints()){
            result.put("code",-1);
            result.put("data","积分不足");
            return ResponseEntity.ok(result);
        }
        user.setPoints(user.getPoints()-product.getPoints()*account);
        product.setAccount(product.getAccount()-account);
        userService.updatePoints(user);
        productService.updateProduct(product);
        Indent indent = new Indent(0, user.getUsername(), product.getProductName(), account, new Date(), user.getName());
        indentService.insert(indent);
        result.put("code",0);
        result.put("data","ok");
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/productDelete")
    public ResponseEntity productDelete(int id){
        HashMap<String, Object> result = new HashMap<>();
        productService.delete(id);
        result.put("code",0);
        result.put("data","ok");
        return ResponseEntity.ok(result);
    }


}
