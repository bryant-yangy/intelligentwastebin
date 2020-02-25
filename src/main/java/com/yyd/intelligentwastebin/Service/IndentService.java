package com.yyd.intelligentwastebin.Service;

import com.yyd.intelligentwastebin.domain.Indent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndentService {
    void insert(Indent indent);
    List<Indent> findByUserName(String username);

    List<Indent> findIdentPage(int page, int limit);

    int getCount();
}
