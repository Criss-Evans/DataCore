package com.hyf;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MysqlSchemaReader{

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/srb_core?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "134685";
    private static final String SQL = "SELECT * FROM ";// 数据库操作

    private String tableName;

    public MysqlSchemaReader(String tableName){
        this.tableName = tableName;
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            log.error("注册数据库驱动失败...", e);
        }catch (SQLException e){
            log.error("获取数据库连接失败...", e);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("关闭数据库连接失败...", e);
            }
        }
    }


    /**
     * 获取表所有的字段
     * @return
     */
    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + this.tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnNames.add(rsmd.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            log.error("获取数据库表列失败...", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    log.error("关闭数据库连接失败...", e);
                }
            }
        }
        return columnNames;
    }

    /**
     * 获取表中字段的所有注释
     * @param tableName
     * @return
     */
    public List<String> getColumnComments(String tableName) {
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        List<String> columnComments = new ArrayList<>();//列名注释集合
        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    log.error("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnComments;
    }

    /**
     * 获取表类型
     * @param tableName
     * @return
     */
    public List<String> getColumnTypes(String tableName){
        List<String> columnTypes = new ArrayList<>();

        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;

        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnTypes.add(rs.getString("Type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    log.error("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnTypes;
    }
    
}
