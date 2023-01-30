package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    private Connection connection;

    @Override
    public Connection createConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        getH2ConnectionProperties().getProperty("db_url")
                );
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    private Properties getH2ConnectionProperties() {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(
                    H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
    // Write your code here!
}

