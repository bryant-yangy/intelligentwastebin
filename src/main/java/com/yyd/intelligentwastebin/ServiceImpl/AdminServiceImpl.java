package com.yyd.intelligentwastebin.ServiceImpl;

import com.yyd.intelligentwastebin.Service.AdminService;
import com.yyd.intelligentwastebin.domain.Admin;
import com.yyd.intelligentwastebin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin findByName(String name) {
        return adminMapper.findByName(name);
    }

    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }
}
