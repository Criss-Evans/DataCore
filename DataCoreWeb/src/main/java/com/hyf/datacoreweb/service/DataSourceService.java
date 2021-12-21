package com.hyf.datacoreweb.service;

import com.hyf.datacoreweb.beans.DataSource;
import com.hyf.datacoreweb.util.Result;
import org.springframework.stereotype.Service;


public interface DataSourceService {

    Result addDaraSource(DataSource dataSource);

    DataSource queryDataSourceByName(String dataSourceName);

}
