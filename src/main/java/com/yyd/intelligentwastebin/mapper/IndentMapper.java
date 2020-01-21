package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.Indent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndentMapper {
    void insert(Indent indent);
    List<Indent> findByUserName(String username);
}
