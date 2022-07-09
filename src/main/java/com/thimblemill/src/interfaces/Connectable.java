package com.thimblemill.src.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface Connectable {

static final String DATABASE = "jdbc:postgresql://ec2-13-211-207-39.ap-southeast-2.compute.amazonaws.com/postgres";
static final String BASEDIR = System.getProperty("user.dir");
static final String PROPSFILE = BASEDIR + "/longacre.properties";



public static Connection getConnection() throws SQLException, IOException, FileNotFoundException {
   
        Properties propa = new Properties();   
       InputStream inna = new FileInputStream(PROPSFILE);
        propa.load(inna); 
        String name = (propa.getProperty("user"));
        String  code = (propa.getProperty("password"));


  Properties props = new Properties();   
 props.put("user", name);
props.put("password", code);
props.setProperty("escapeSyntaxCallMode", "callIfNoReturn");
String url = DATABASE;
       return DriverManager.getConnection(url, props);
 }
};


