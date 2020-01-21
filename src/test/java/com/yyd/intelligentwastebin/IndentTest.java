package com.yyd.intelligentwastebin;

import com.yyd.intelligentwastebin.Service.IndentService;
import com.yyd.intelligentwastebin.domain.Indent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class IndentTest {
    @Autowired
    IndentService indentService;
    @Test
    public void insert(){
        indentService.insert(new Indent(0,"wangyue","饮料",5,new Date(),"王越"));
    }
    @Test
    public void findByName(){
        List<Indent> wangyue = indentService.findByUserName("wangyue");
        for (Indent indent : wangyue) {
            System.out.println(indent);
        }
    }
}
