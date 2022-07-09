
package com.thimblemill.src.interfaces;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Manageable {

 

public void toKML (String output, String input)throws FileNotFoundException, SQLException,IOException, InterruptedException;
public List kmlList() throws ClassNotFoundException, FileNotFoundException, IOException;
  public List jsonList() throws ClassNotFoundException, FileNotFoundException, IOException;
 public void fileDelete(String dropped) throws IOException;
public void renameMap(String oldun, String newun)throws FileNotFoundException, IOException;
public Map allHashes();
public void outJson(String intable, String outmap) throws ClassNotFoundException, SQLException, FileNotFoundException, URISyntaxException, IOException, InterruptedException;
 // public void move2git() throws FileNotFoundException, IOException; 
  public  void copyStations(String table, String name)throws ClassNotFoundException, SQLException, IOException;
public   void copyShires (String table, String name)throws ClassNotFoundException, SQLException, IOException;
public void mInters(String outTable, String inTable1, String inTable2)throws SQLException ;
public void mBuf(Integer distance, String intable, String outtable);
}


