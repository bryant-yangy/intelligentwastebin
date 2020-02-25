package com.yyd.intelligentwastebin.ServiceImpl;

import com.yyd.intelligentwastebin.mapper.UserMapper;
import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        int id = userMapper.insert(user);
        return id;
    }
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    @Override
    public User findByName(String username) {
        return  userMapper.findByName(username);

    }
    @Override
    public void insertFace(int id) {
        userMapper.insertFace(id);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void updatePoints(User user) {
        userMapper.updatePoints(user);
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

    @Override
    public List<User> findUserPage(int page, int limit) {
        int n = (page - 1) * limit;
        int m = limit;
        return userMapper.findByPage(n, m);
    }
}
