package com.example.ygo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.example.ygo.dao")
public class YgoApplication

{
    public static void main(String[] args) {
        SpringApplication.run(YgoApplication.class,args);
    }
}
