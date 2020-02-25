package com.yyd.intelligentwastebin.ServiceImpl;

import com.yyd.intelligentwastebin.Service.IndentService;
import com.yyd.intelligentwastebin.domain.Indent;
import com.yyd.intelligentwastebin.mapper.IndentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentServiceImpl implements IndentService {
    @Autowired
    IndentMapper  indentMapper;
    @Override
    public void insert(Indent indent) {
        indentMapper.insert(indent);
    }

    @Override
    public List<Indent> findByUserName(String username) {
        return  indentMapper.findByUserName(username);
    }

    @Override
    public List<Indent> findIdentPage(int page, int limit) {
        int n = (page - 1) * limit;
        int m = limit;
        return  indentMapper.findByPage(n, m);
    }

    @Override
    public int getCount() {
        return indentMapper.getCount();
    }
}
