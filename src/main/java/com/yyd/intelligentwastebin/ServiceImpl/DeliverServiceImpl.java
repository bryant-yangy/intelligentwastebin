package com.yyd.intelligentwastebin.ServiceImpl;

import com.yyd.intelligentwastebin.Service.DeliverService;
import com.yyd.intelligentwastebin.domain.Deliver;
import com.yyd.intelligentwastebin.mapper.DeliverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliverServiceImpl implements DeliverService {
    @Autowired
    DeliverMapper deliverMapper;
    @Override
    public int insert(Deliver deliver) {
        return deliverMapper.insert(deliver);
    }

    @Override
    public List<Deliver> findAll() {
        return deliverMapper.findAll();
    }



    @Override
    public List<Deliver> findByUserName(String name) {
        return deliverMapper.findByUserName(name);
    }

    @Override
    public List<Deliver> findDeliverPage(int page, int limit) {
        int n = (page - 1) * limit;
        int m = limit;
        return deliverMapper.findByPage(n, m);
    }

    @Override
    public int getCount() {
        return deliverMapper.getCount();
    }
}
