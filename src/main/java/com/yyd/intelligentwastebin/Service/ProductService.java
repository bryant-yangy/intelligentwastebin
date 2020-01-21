package com.yyd.intelligentwastebin.Service;

import com.yyd.intelligentwastebin.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     int insert(Product product);
     List<Product> findAll();
     Product findById(int id);
     void updateProduct(Product product);
     int getCount();
     void delete(int id);
}
