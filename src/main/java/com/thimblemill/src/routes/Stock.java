package com.thimblemill.src.routes;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.thimblemill.src.interfaces.Connectable;
import com.thimblemill.src.interfaces.Cruddable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.thimblemill.src.models.Assets;
import com.thimblemill.src.models.Place;
import java.util.Vector;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

public class Stock implements Connectable, Cruddable{
     
    
    public List allRecords() throws ClassNotFoundException, SQLException, IOException {
         
        List <Object> rono = null;

      Connection conn = Connectable.getConnection();
      
      
            String runFunction = "select * from nqstock.getsites();";
            try (Statement s = conn.createStatement(); ResultSet r = s.executeQuery(runFunction)) {
                rono = new ArrayList();
                while(r.next()) {
                    Assets mitch = new Assets();
                    mitch.setGid(r.getInt("gid"));
                    mitch.setX(r.getDouble("x"));
                    mitch.setY(r.getDouble("y"));
                    mitch.setFeature(r.getString("feature"));
                    mitch.setName(r.getString("name"));
                    mitch.setStation(r.getString("station"));
                    // mitch.setGeometry(r.getObject("geometry"));
                    rono.add(mitch);
                }
                r.close();
            }
            conn.close();
        return rono;


    } 

    public void getLocation(String outTable,Integer idn) throws ClassNotFoundException, IOException, SQLException {
           Connection conna = Connectable.getConnection();
        
       
            String location = String.format(QUERYLOCATION, outTable,idn);
            try (Statement vw = conna.createStatement()) {
                vw.execute(location);
                vw.close();
            }
            conna.close();
            
        }
            

    
     public void getLocation2(String outTable,String name) throws ClassNotFoundException, IOException, SQLException {
         Connection connb = Connectable.getConnection();
            String location = String.format(QUERYLOCATION2, outTable,name);
            try (Statement vw = connb.createStatement()) {
                vw.execute(location);
                 vw.close();
            }
           
             connb.close();
        }
 
    public Vector allStations() throws ClassNotFoundException, IOException, SQLException {
        Vector<String> placelist;
        
               try (Connection connc = Connectable.getConnection()) {
                   placelist = new Vector<String>();
                   try (Statement s = connc.createStatement()) {
                       ResultSet rr = s.executeQuery("select * from nqstock.cattle();");
                       while(rr.next()) {
                           
                           placelist.add(rr.getString("station"));
                       }
                       rr.close();
                   }
               }
        return placelist;
        }
   
   
    
     
 public List allPlaces() throws ClassNotFoundException, IOException, SQLException{
             Connection connd = Connectable.getConnection();
     List <Object> places;
        
            String runFunction2 = "select * from nqstock.getplaces();";
                try (Statement s = connd.createStatement(); ResultSet r = s.executeQuery(runFunction2)) {
                    places = new ArrayList();
                    while(r.next()) {
                        
                        Place titch = new Place();
                        titch.setGid(r.getInt("gid"));
                        titch.setX(r.getDouble("x"));
                        titch.setY(r.getDouble("y"));
                        titch.setName(r.getString("name"));
                        titch.setFeature(r.getString("feature"));
                        titch.setShire(r.getString("shire"));
                        //titch.setGeometry(r.getObject("geometry"));
                        places.add(titch);
                    } 
                }
            connd.close();
        return places;
        }
  
 

                 
    @Override
 public void makeRecord(int gid, String feature, String name, String station, float x, float y) throws ClassNotFoundException, SQLException {
        try {
            Connection connd;
            
            connd = Connectable.getConnection();
            
            
            CallableStatement proc;
            proc = connd.prepareCall("{call nqstock.instock(?,?, ?, ?,?, ?)}");
            {
                proc.setInt(1, gid);
                proc.setString(2, feature);
                proc.setString(3, name);
                proc.setString(4, station);
                proc.setFloat(5, x);
                proc.setFloat(6, y);
                proc.execute();
                connd.close();
                
            }       } catch (IOException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
 }


        public void updateRecord(String name, int gid) throws ClassNotFoundException,IOException, SQLException {
                Connection conned = Connectable.getConnection();

            try (CallableStatement s = conned.prepareCall("{call nqstock.newname(?,?)}" )) {
            s.setString(1, name);
            s.setInt(2, gid);
            s.execute();
             conned.close();
    }}

    public void deleteRecord(int gid) throws ClassNotFoundException, SQLException {
        try {
            Connection connel = Connectable.getConnection();
            
            CallableStatement t = connel.prepareCall("{call nqstock.delsite(?)}"  );
            t.setInt(1, gid);
            t.execute();
            connel.close();
        } catch (IOException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }

       } 

        public Vector allShires() throws ClassNotFoundException, SQLException {
                  
                      try {
                          
                          Connection connec = Connectable.getConnection();
                          Vector<String> placelist = null;
                          
                          placelist = new Vector<String>();
                          try (Statement s = connec.createStatement()) {
                              ResultSet rr = s.executeQuery("select * from nqstock.shires();");
                              while(rr.next()) {
                                  
                                  placelist.add(rr.getString("shire"));
                              }  rr.close();   }
                          
                          connec.close();
                          return placelist;
                      } catch (IOException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
                  
                  

       public  List allTables() throws ClassNotFoundException, SQLException, IOException{

            Connection connet = Connectable.getConnection();
        List <Object> layers;
        
            Statement b = connet.createStatement();
            ResultSet v = b.executeQuery("select tablename from nqstock.gettabnames()");
            layers = new ArrayList();
            ResultSetMetaData metaData = v.getMetaData();
            int columnCount  = metaData.getColumnCount();
            while(v.next()) {
                List<Object> lay =new ArrayList();
                Map<String, Object> p = new HashMap<String,Object>();
                for (int i = 1; i <= columnCount; i++ ){
                    p.put(metaData.getColumnLabel(i),v.getObject(i));
                    lay.add(v.getObject(i));
                }
                
                layers.add(lay);
            }         v.close();
            connet.close();
        return layers;
        }
    
     

  public void dumpTable(String dropper) throws SQLException {
               try {
                   Connection cornet = Connectable.getConnection();
                   
                   String dropped = String.format("DROP TABLE nqstock.%s CASCADE;", dropper);
                   try (Statement p = cornet.createStatement()) {
                       p.executeUpdate(dropped);
                       p.close();
                   }
                   
                   cornet.close();
               } catch (IOException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
           }    

 
  //COMPOSER
//public void newTable(String tablename) throws ClassNotFoundException, SQLException, IOException {
//           Connect villr = new Connect();   
//       String NEWTABLE = String.format(MAKETABLE, tablename);
//       String COPY2TABLE = String.format(COPYDAT, tablename, QRYFILE);
//  
//       String NEWGEOMETRY = String.format(NEWGEOM, tablename);
//       String UPDGEOM = String.format(MAKEGEOM, tablename);
//        try (Connection conna = villr.getConnection(); Statement o = conna.createStatement()) {
//            o.execute(NEWTABLE);
//           try (Statement p = conna.createStatement()) {
//               p.execute(COPY2TABLE);
//               p.close();
//           }
//           try (Statement s = conna.createStatement()) {
//               s.execute(NEWGEOMETRY);
//               s.close();
//           }
//           try (Statement t = conna.createStatement()) {
//               t.execute(UPDGEOM);
//               t.close();
//           }
//            conna.close();
//        }
          
};

    

    


    

