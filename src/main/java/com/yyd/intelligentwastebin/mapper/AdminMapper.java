package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    Admin  findByName(String name);
    int insert(Admin admin);
}
