package com.yyd.intelligentwastebin;

import com.yyd.intelligentwastebin.Service.DeliverService;
import com.yyd.intelligentwastebin.Service.UserService;
import com.yyd.intelligentwastebin.domain.Deliver;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class DeliverTest {
    @Autowired
    DeliverService deliverService;
    @Test
    void insert(){

    }
    @Test
    void findAll(){
        List<Deliver> all = deliverService.findAll();
        for (Deliver deliver : all) {
            System.out.println(deliver);
        }

    }
    @Test
    void findByUserName(){
        List<Deliver> all = deliverService.findByUserName("wangyue");
        for (Deliver deliver : all) {
            System.out.println(deliver);
        }
    }
}
