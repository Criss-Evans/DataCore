package com.hyf.datacoreweb.service;

import com.hyf.datacoreweb.beans.DataSource;
import org.springframework.stereotype.Service;


public interface DataSourceService {

    String addDaraSource(DataSource dataSource);

    DataSource queryDataSourceByName(String dataSourceName);

}
