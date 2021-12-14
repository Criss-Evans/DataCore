package com.hyf.bean;

import java.util.List;

public abstract class Reader implements R{



    public abstract List<SqlBean> run(String tableName);

}
