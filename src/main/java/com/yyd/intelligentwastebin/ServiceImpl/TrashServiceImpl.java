package com.yyd.intelligentwastebin.ServiceImpl;

import com.yyd.intelligentwastebin.Service.TrashService;
import com.yyd.intelligentwastebin.domain.Trash;
import com.yyd.intelligentwastebin.mapper.TrashMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrashServiceImpl implements TrashService {
    @Autowired
    TrashMapper trashMapper;
    @Override
    public List<Trash> findAll() {
        return trashMapper.findAll();
    }

    @Override
    public int getPoint(String trashName) {
        return trashMapper.getPoint(trashName);
    }
}
