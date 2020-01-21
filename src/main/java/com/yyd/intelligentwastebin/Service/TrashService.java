package com.yyd.intelligentwastebin.Service;

import com.yyd.intelligentwastebin.domain.Trash;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TrashService {
    List<Trash> findAll();
    int getPoint(String trashName);
}
