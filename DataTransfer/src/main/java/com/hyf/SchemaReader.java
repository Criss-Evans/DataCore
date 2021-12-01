package com.hyf;

import java.sql.Connection;
import java.util.List;

public abstract class SchemaReader {

    private String tableName;

    public SchemaReader(String tableName){
        this.tableName = tableName;
    }

    public abstract Connection getConnection();

    public abstract void closeConnection(Connection conn);

    public abstract List<String> getColumnNames();

    public abstract List<String> getColumnTypes();

    public abstract List<String> getColumnComments();

}
