package com.yyd.intelligentwastebin.Service;

import com.yyd.intelligentwastebin.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
      int addUser(User user);
      List<User> findAll();
      User findByName(String username);
      void insertFace(int id);
      User findById(int id);
      void updatePoints(User user);
      int getCount();
      List<User> findUserPage(int currentPage,int limit);
}
