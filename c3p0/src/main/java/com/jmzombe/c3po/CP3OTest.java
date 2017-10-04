package com.jmzombe.c3po;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class CP3OTest {

  public static void main(String[] args) throws IOException, PropertyVetoException, SQLException {
    Connection connection = null;
  
    ComboPooledDataSource dataSource = PooledDataSource.getInstance();
    
    try (Connection connection2 = dataSource.getConnection();) {
    }
    
    
    
    connection = dataSource.getConnection();
    connection.close();
  }

}
