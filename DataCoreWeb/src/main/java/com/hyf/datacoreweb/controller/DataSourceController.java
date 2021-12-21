package com.hyf.datacoreweb.controller;

import com.hyf.datacoreweb.beans.DataSource;
import com.hyf.datacoreweb.service.DataSourceService;
import com.hyf.datacoreweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataSource")
public class DataSourceController {

    @Autowired
    public DataSourceService dataSourceService;

    @PostMapping("/addDataSource")
    public Result addDataSource(@RequestBody DataSource dataSource){
        Result result = dataSourceService.addDaraSource(dataSource);
        return result;
    }

}
