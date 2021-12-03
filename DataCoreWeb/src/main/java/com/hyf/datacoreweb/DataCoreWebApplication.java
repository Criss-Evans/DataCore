package com.hyf.datacoreweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyf.datacoreweb.mapper")
public class DataCoreWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCoreWebApplication.class, args);
    }

}
