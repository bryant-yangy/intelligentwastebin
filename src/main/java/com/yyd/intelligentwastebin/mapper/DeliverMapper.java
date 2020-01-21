package com.yyd.intelligentwastebin.mapper;

import com.yyd.intelligentwastebin.Service.DeliverService;
import com.yyd.intelligentwastebin.domain.Deliver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliverMapper {
    int insert(Deliver deliver);
    List<Deliver> findAll();
    List<Deliver> findByUserName(String Name);
}
