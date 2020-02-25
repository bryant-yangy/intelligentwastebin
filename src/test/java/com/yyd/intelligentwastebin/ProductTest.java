package com.yyd.intelligentwastebin;

import com.yyd.intelligentwastebin.Service.ProductService;
import com.yyd.intelligentwastebin.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductService productService;
    @Test
    void  insert(){

    }
    @Test
    void  findAll(){

    }
    @Test
    void  findByPage(){
        List<Product> byPage = productService.findByPage(2, 5);
        for (Product product : byPage) {
            System.out.println(product);
        }
    }
    @Test
    void  findById(){

    }
    @Test
    void  updateAccount(){

    }
    @Test
    void  gerCount(){

    }
    @Test
    void delete(){

    }
}
