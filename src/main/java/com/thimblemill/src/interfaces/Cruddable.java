package com.thimblemill.src.interfaces;


import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;


public interface Cruddable {
 
public void makeRecord(int gid, String feature,String station, String name, float x, float y) throws ClassNotFoundException, SQLException ; 
public void updateRecord(String name, int gid) throws ClassNotFoundException, IOException, SQLException;

public void deleteRecord(int gid) throws ClassNotFoundException, SQLException;
public  List allTables() throws ClassNotFoundException, SQLException, IOException;
public void dumpTable(String dropper) throws SQLException;
public List allRecords() throws ClassNotFoundException, SQLException, IOException;
public List allPlaces() throws ClassNotFoundException, SQLException, IOException;
public Vector allShires() throws ClassNotFoundException, SQLException;


   //Composer
//static final String MAKETABLE = "create  table nqstock.%s (gid int primary key,x float, y float, name varchar, feature varchar, station varchar )"; 
//  static final String COPYDAT = "COPY %s FROM '%s' DELIMITER '\t'";
//  static final String NEWGEOM = "ALTER TABLE nqstock.%s ADD COLUMN geometry geometry";
//  static final String MAKEGEOM = "UPDATE nqstock.%s SET geometry = ST_SetSRID(ST_Point(x::float, y::float),4326)";
static final String QUERYLOCATION = "create table nqstock.%s as select gid,x,y,name,feature,geometry from nqstock.sites where \"gid\" = %d;";
static final String QUERYLOCATION2 = "create table nqstock.%s as select gid,x,y,name,feature,geometry from nqstock.place where \"name\" = %s;";
};


  
   


