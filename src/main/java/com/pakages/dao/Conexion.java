package com.pakages.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static BasicDataSource dataSource=null;
    
    private static DataSource getDataSource(){
        if (dataSource==null){
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            
            dataSource.setUsername("root");//b5895e5bfd1b3c
            dataSource.setPassword("root");//8ca03b4e
            dataSource.setUrl("jdbc:mysql://localhost:3306/las_torres_db");
            //jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_5425e1591239cd3
            dataSource.setInitialSize(20);
            /*dataSource.setMaxIdle(15);
            dataSource.setMaxTotal(20);
            dataSource.setMaxWaitMillis(5000);*/
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException{
            return getDataSource().getConnection();
    }
}
