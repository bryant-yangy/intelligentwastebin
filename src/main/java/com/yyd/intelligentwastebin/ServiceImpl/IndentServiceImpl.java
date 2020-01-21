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
    IndentMapper orderMapper;
    @Override
    public void insert(Indent indent) {
        orderMapper.insert(indent);
    }

    @Override
    public List<Indent> findByUserName(String username) {
        return orderMapper.findByUserName(username);
    }
}
