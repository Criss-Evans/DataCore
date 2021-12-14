package com.hyf.datacoreweb;

import com.hyf.datacoreweb.beans.DataSource;
import com.hyf.datacoreweb.mapper.DataSourceMapper;
import com.hyf.datacoreweb.service.DataSourceService;
import com.hyf.datacoreweb.service.impl.DataSourceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DataCoreWebApplicationTests {

    @Autowired
    private DataSourceMapper dataSourceMapper;


    @Test
    void contextLoads() {

        List<DataSource> dataSources = dataSourceMapper.selectByMap(null);

        for (DataSource dataSource : dataSources) {
            System.out.println(dataSource.getId());
        }

    }

}
