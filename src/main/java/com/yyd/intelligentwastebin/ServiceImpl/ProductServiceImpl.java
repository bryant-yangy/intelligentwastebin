package com.yyd.intelligentwastebin.ServiceImpl;

import com.yyd.intelligentwastebin.Service.ProductService;
import com.yyd.intelligentwastebin.domain.Product;
import com.yyd.intelligentwastebin.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public List<Product> findByPage(int page, int count) {
        int n = (page - 1) * count;
        int m = count;
        return productMapper.findByPage(n, count);
    }

    @Override
    public Product findById(int id) {
        return productMapper.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public int getCount() {
        return productMapper.getCount();
    }

    @Override
    public void delete(int id) {
        productMapper.delete(id);
    }
}
