package com.hyf.datacoreweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyf.datacoreweb.beans.DataSource;
import com.hyf.datacoreweb.mapper.DataSourceMapper;
import com.hyf.datacoreweb.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public String addDaraSource(DataSource dataSource) {

        int insert = dataSourceMapper.insert(dataSource);

        // 数据源名字不能重复，首先看数据库是否有该数据源名称
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("name", dataSource.getName());
        List<DataSource> dataSources = dataSourceMapper.selectByMap(queryMap);
        if(dataSources.size() != 0){
            log.error("数据源名称重复...");
            return "数据源名称已存在，请使用其他名称！";
        }

        return insert != 0 ? "添加数据源成功！" : "添加数据源失败！";
    }

    @Override
    public DataSource queryDataSourceByName(String dataSourceName) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("name", dataSourceName);
        List<DataSource> targetDataSource = dataSourceMapper.selectByMap(queryMap);

        if(targetDataSource.isEmpty()){
            return null;
        }

        DataSource result = null;
        for (DataSource dataSource : targetDataSource) {
            result = dataSource;
        }

//        Wrapper<DataSource> queryWrapper = new QueryWrapper<>();




        return result;
    }

}
