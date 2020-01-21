package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.domain.Trash;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface TrashMapper {
    List<Trash> findAll();
    int getPoint(String trashName);

}
