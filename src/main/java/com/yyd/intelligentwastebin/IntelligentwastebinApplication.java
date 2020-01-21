package com.yyd.intelligentwastebin;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan(basePackages = "com.yyd.*.mapper")
public class IntelligentwastebinApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntelligentwastebinApplication.class, args);
    }


}
