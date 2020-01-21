package com.yyd.intelligentwastebin;

import com.yyd.intelligentwastebin.Service.TrashService;
import com.yyd.intelligentwastebin.domain.Trash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TrashTest {
    @Autowired
    TrashService trashService;
    @Test
    public void getPoint(){
        System.out.println(trashService.getPoint("易拉罐"));
    }
    @Test
    public void findAll(){
        List<Trash> list  = trashService.findAll();
        for (Trash trash : list) {
            System.out.println(trash.toString());
        }
    }

}
