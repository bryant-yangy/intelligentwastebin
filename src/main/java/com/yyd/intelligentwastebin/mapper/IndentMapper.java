package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.Indent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.PostConstruct;
import java.util.List;

@Mapper
public interface IndentMapper {
    void insert(Indent indent);
    List<Indent> findByUserName(String username);

    List<Indent> findByPage(@Param("n") int n, @Param("m") int m);

    int getCount();
}
