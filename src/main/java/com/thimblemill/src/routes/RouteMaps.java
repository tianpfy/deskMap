package com.thimblemill.src.routes;

import com.thimblemill.src.interfaces.Manageable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thimblemill.src.interfaces.Connectable;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteMaps implements Connectable, Manageable{
    
                  public Map allHashes(){
     Map<String, String> location = new HashMap<>();
     location.put("OGR2OGR", "ogr2ogr -f  \"KML\"  \"resources/kml/%s.kml\"  \"resources/json/%s.json\" ");
     
     location.put("STASSETS", "create table nqstock.%s as select gid, feature, name, x, y, geometry, station from nqstock.sites where \"station\" = '%s';");
     location.put("TOJSON", "SELECT json_build_object('type', 'FeatureCollection','features', json_agg(json_build_object('type', 'Feature','gid',gid,'geometry', ST_AsGeoJSON(geometry)::json,'properties', jsonb_set(row_to_json(%s)::jsonb,'{geometry}','0',false)))) FROM nqstock.%s;");
     location.put("LGPLACES", "create table nqstock.%s as select gid, x, y, feature, name, shire, geometry from nqstock.place where \"shire\" = '%s';");
     location.put("INTERSD", "create table nqstock.%s as select ST_Intersection(b.geometry,a.geometry) as geometry, a.name, b.feature, a.gid, b.name as nom from nqstock.%s as a, nqstock.%s as b where ST_Intersects(b.geometry,a.geometry);");
     location.put("BUFFD", "create table nqstock.%s as select gid,name,feature, ST_Transform( ST_Buffer(ST_Transform(geometry,23880), %d),4326) as geometry from nqstock.%s;");
      location.put("KMLDIR", "resources/kml");
     location.put("KMLFILE", "resources/kml/%s.kml");
     location.put("TOJSON", "SELECT json_build_object('type', 'FeatureCollection','features', json_agg(json_build_object('type', 'Feature','gid',gid,'geometry', ST_AsGeoJSON(geometry)::json,'properties', jsonb_set(row_to_json(%s)::jsonb,'{geometry}','0',false)))) FROM nqstock.%s;");
     location.put("JSONFILE", "resources/json/%s.json");
     location.put("JSONDIR", "resources/json");
     
     return location;
             }
         
    public  void copyStations(String table, String name)throws ClassNotFoundException, SQLException, IOException {
       Connection corner = Connectable.getConnection();
         Map rondo = allHashes();
           String lomo = (String) rondo.get("STASSETS");
        
              String NEWTABLE = String.format(lomo, table, name);
            try (Statement o = corner.createStatement()) {
                o.execute(NEWTABLE);
                  o.close();
            }     
            corner.close();
        }               
                  
  public List jsonList() throws ClassNotFoundException, FileNotFoundException, IOException {
 
      Map fonto = allHashes();
           String romo = (String) fonto.get("JSONDIR");
           
           File[] paths;
      List<String> files = new ArrayList();
      File file = new File(romo);
        paths = file.listFiles(( dir,  name)->name.toLowerCase().endsWith(".json"));
     for (File path1 : paths) {
           files.add(path1.getName().replaceFirst("[.][^.]+$", ""));
      
      }
     
       return files;
  };
  
    
       public void fileDelete(String dropped) throws IOException {
       Map gonto = allHashes();
           String tomo = (String) gonto.get("JSONFILE");
           
        String delpath = String.format(tomo, dropped);
        Path path = Paths.get(delpath);
        Files.delete(path);
             };
       
         public void kmlDelete(String dropit) throws IOException {
           Map honto = allHashes();
           String tomo = (String) honto.get("KMLFILE");
        String delit = String.format(tomo, dropit);
        Path path2 = Paths.get(delit);
        Files.delete(path2);        
    };
       

   public void toKML (String output, String input)throws  FileNotFoundException, SQLException,IOException, InterruptedException{
        Map jonto = allHashes();
           String uomo = (String) jonto.get("OGR2OGR");
        
    String tokml = String.format(uomo, output, input);   
    String [] command1 = {"cmd","/c", tokml}; 
 
     ProcessBuilder probg = new ProcessBuilder( command1 );
    
        Process prodh = probg.start();
      
}   


   public void renameMap(String oldun, String newun)throws FileNotFoundException, IOException {
       
          Map honto = allHashes();
           String tromo = (String) honto.get("JSONDIR");
           
      File oldfile = new File(tromo + String.format( "/%s.json",oldun));
      File newfile = new File(tromo +  String.format( "/%s.json",newun));
      if(oldfile.renameTo(newfile)) {
         System.out.println("File name changed successfully");
      } else {
         System.out.println("Rename failed");
      } 
     
   }

        

    public void outJson(String intable, String outmap) throws ClassNotFoundException, SQLException, FileNotFoundException, URISyntaxException, IOException, InterruptedException {
        Map donto = allHashes();
           String tomo = (String) donto.get("JSONFILE");
        String omo = (String) donto.get("TOJSON");
         Connection corn = Connectable.getConnection();
         
        String MAPDIRECTORY = String.format(tomo, outmap);
        String JQUERY = String.format(omo, intable, intable);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(MAPDIRECTORY)), "UTF-8"));
        Statement stat = corn.createStatement();
        try (ResultSet rs = stat.executeQuery(JQUERY)) {
            while (rs.next()) {
              writer.append(rs.getString(1));
            }
           // input.close();
            stat.close();
            corn.close();
            writer.close();
        }
     }
     
     
          
     public List kmlList() throws ClassNotFoundException, FileNotFoundException, IOException {
      Map honcho = allHashes();
         String nono = (String) honcho.get("KMLDIR"); 
        
       File[] paths;
      List<String> files = new ArrayList();
      File fili = new File(nono);
        paths = fili.listFiles(( dir,  name)->name.toLowerCase().endsWith(".kml"));
     for (File path1 : paths) {
           files.add(path1.getName().replaceFirst("[.][^.]+$", ""));
       
      }
       return files;
} 
  
    
   public void mBuf( Integer distance,String intable,  String outtable) {
                      
                      try {
                          Connection connec = Connectable.getConnection();
                          
                          Map tonto = allHashes();
                          String omo = (String) tonto.get("BUFFD");
                          String bf = String.format(omo,outtable, distance, intable);
                          
                          Statement v = connec.createStatement();
                          v.execute(bf);
                          connec.close();
                      } catch (SQLException ex) {
                          Logger.getLogger(RouteMaps.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (IOException ex) {
                          Logger.getLogger(RouteMaps.class.getName()).log(Level.SEVERE, null, ex);
                      }}
                      
   

public void mInters(String outTable, String inTable1, String inTable2) throws SQLException {
                      try {
                          Connection conneca = Connectable.getConnection();
                          Map fonto = allHashes();
                          String romo = (String) fonto.get("INTERSD");
                          String tersect = String.format(romo, outTable, inTable1, inTable2);
                          Statement y = conneca.createStatement();
                          y.execute(tersect);
                      } catch (IOException ex) {
                          Logger.getLogger(RouteMaps.class.getName()).log(Level.SEVERE, null, ex);
                      }
        } 



          public void move2git() throws FileNotFoundException, IOException {
  
                 Map fonto = allHashes();
           String gromo = (String) fonto.get("JSONDIR");
ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "gitgo.bat");
File dira = new File(gromo);
pb.directory(dira);
Process t = pb.start();
}

 public   void copyShires (String table, String name)throws ClassNotFoundException, SQLException, IOException {
            Connection connecta = Connectable.getConnection();
     Map monto = allHashes();
           String domo = (String) monto.get("LGPLACES");
        
              String NEWTABLE = String.format(domo, table, name);
              Statement o = connecta.createStatement();
                  o.execute(NEWTABLE);
                  o.close();
                  connecta.close();
              }
            
        
};    
  
//          public void move2s3() throws FileNotFoundException, IOException {
//            
//              ProcessBuilder pc = new ProcessBuilder("cmd", "/c", "aws s3 sync . s3://olkola/json --exclude \"git/*\"");
//File dir = new File("C:/Users/jmona/OneDrive/Desktop/NQldroutes/mvRoute2/resources/json");
//pc.directory(dir);
//Process p = pc.start();
//}
//

     
//COMPOSER
//   public void fileWriter(String filer) throws FileNotFoundException, IOException {
//        
//       try {
//           BufferedWriter bf = null;
//           bf = new BufferedWriter(new FileWriter(QRYFILE));
//           bf.write(filer);
//           bf.flush();
//           bf.close();
//       } catch (IOException ex) {
//           Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
//       }}
