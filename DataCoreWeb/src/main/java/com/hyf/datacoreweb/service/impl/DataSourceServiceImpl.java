package com.hyf.datacoreweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyf.datacoreweb.beans.DataSource;
import com.hyf.datacoreweb.mapper.DataSourceMapper;
import com.hyf.datacoreweb.service.DataSourceService;
import com.hyf.datacoreweb.util.Result;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
    public Result addDaraSource(DataSource dataSource) {

        int insert = 0;

        try {
            insert = dataSourceMapper.insert(dataSource);
        }
        catch (Exception e){
            System.out.println("");
            return Result.error(500, "数据源名称重复！");
        }

        if (insert != 0)
            return Result.ok("添加数据源成功！");
        else
            return Result.error(500, "添加数据源失败！");
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
