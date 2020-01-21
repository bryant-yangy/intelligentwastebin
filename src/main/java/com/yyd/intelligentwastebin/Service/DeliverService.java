package com.yyd.intelligentwastebin.Service;

import com.yyd.intelligentwastebin.domain.Deliver;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeliverService {
    int insert(Deliver deliver);
    List<Deliver> findAll();
    List<Deliver> findByUserName(String name);
}
