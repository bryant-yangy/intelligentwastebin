package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    List<User> findAll();

    User findByName(String username);

    void insertFace(int id);

    User findById(int id);

    void updatePoints(User user);

    int getCount();

    List<User> findByPage(@Param("n")int n,@Param("m")int m);
}
