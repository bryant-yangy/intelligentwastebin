package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
     int insert(Product product);
     List<Product> findAll();
     List<Product> findByPage(@Param("n")int n,@Param("m") int m);
     Product findById(int id);
     void updateProduct(Product product);
     int getCount();
     void delete(int id);

}
