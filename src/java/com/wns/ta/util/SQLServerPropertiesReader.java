/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wns.ta.util;

import com.wns.ta.vo.ConnectionVO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Sumit Malhotra
 */
public class SQLServerPropertiesReader {
    
    public ConnectionVO getConnectionParameters() {
        ConnectionVO connectionVO = new ConnectionVO();
        try {

            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream("C:/customwebapp/SQL.properties");
            properties.load(inputStream);
            
            connectionVO.setUsername(properties.getProperty("Username"));
            connectionVO.setPassword(properties.getProperty("Password"));
            
            connectionVO.setServer(properties.getProperty("Server"));
            connectionVO.setDatabase(properties.getProperty("Database"));




        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return connectionVO;
    }

    
}
