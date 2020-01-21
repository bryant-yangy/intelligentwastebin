package com.yyd.intelligentwastebin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyd.intelligentwastebin.ServiceImpl.UserServiceImpl;
import com.yyd.intelligentwastebin.domain.User;
import com.yyd.intelligentwastebin.utils.Base64Util;
import com.yyd.intelligentwastebin.utils.FaceUtil;
import com.yyd.intelligentwastebin.utils.FileUtil;
import com.yyd.intelligentwastebin.utils.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.*;

@SpringBootTest

class IntelligentwastebinApplicationTests {
    @Test
    public  void tese(){
        System.out.println(FaceUtil.getAuth());
    }
}
