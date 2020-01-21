package com.yyd.intelligentwastebin.Service;

import com.yyd.intelligentwastebin.domain.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    Admin findByName(String name);
    int insert(Admin admin);
}
