package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
     int insert(Product product);
     List<Product> findAll();
     Product findById(int id);
     void updateProduct(Product product);
     int getCount();
     void delete(int id);
}
