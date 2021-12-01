package com.hyf;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Slf4j
public class test {

    public static void main(String[] args) {

        Properties properties = new Properties();
        InputStream in = Object.class.getResourceAsStream("core.properties");
        try{
            properties.load(in);
        }catch (IOException e) {
            log.error("读取配置文件失败...", e);
        }
        System.out.println(properties.get("username"));
    }

}
