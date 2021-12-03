package com.hyf.datacoreweb.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class DataSource implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer type;

    private String username;

    private String password;

    private String ip;

    private Integer port;

    private String url;

    public DataSource(String name, Integer type, String username, String password, String ip, Integer port, String url){
        this.name = name;
        this.type = type;
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.port = port;
        this.url = url;
    }

}
