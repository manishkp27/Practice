/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wns.ta.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.wns.ta.util.SQLServerPropertiesReader;
import com.wns.ta.vo.ConnectionVO;
import java.sql.Connection;

/**
 *
 * @author Sumit Malhotra
 */
public class SQLServerConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            ConnectionVO vo = new SQLServerPropertiesReader().getConnectionParameters();
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser(vo.getUsername());
            ds.setPassword(vo.getPassword());
            ds.setServerName(vo.getServer());
            ds.setDatabaseName(vo.getDatabase());
            con = ds.getConnection();
            
            System.out.println("SQLServerConnection getConnection()");
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return con;

    }

}
