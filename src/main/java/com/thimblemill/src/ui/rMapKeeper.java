package com.thimblemill.src.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.thimblemill.src.routes.RouteMaps;
import com.thimblemill.src.routes.MapDisplay;
import com.thimblemill.src.interfaces.Connectable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class rMapKeeper extends JFrame implements Connectable{
    

  public rMapKeeper() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, FileNotFoundException, IOException
  {
     
     super("North Queensland maps");
     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      
     setResizable(false);
  //border = BorderFactory.createBevelBorder(BevelBorder.RAISED)
   RouteMaps rot = new RouteMaps();
   
  Font font = new Font("Arial",Font.PLAIN,14);
      Font font2 = new Font("Arial",Font.PLAIN,14);
      
this.setSize(new Dimension(700,450));
  JPanel panel =  new JPanel();
  panel.setBackground(Color.decode("#ffffe6"));
  panel.setPreferredSize(new Dimension (530,430));
  JPanel panel2 = new JPanel();
  panel2.setPreferredSize(new Dimension(160,430));
  panel2.setBackground(Color.decode("#ffffe6"));
  JPanel title1 =  new JPanel();
  title1.setPreferredSize(new Dimension(510,20));
  JPanel panel3 = new JPanel(); 
  panel3.setPreferredSize(new Dimension(510,130));
  JPanel title2 = new JPanel();
  title2.setPreferredSize(new Dimension(510,20));
  JPanel panel4 = new JPanel();
  panel4.setPreferredSize(new Dimension(510,130));
  JPanel panel5 = new JPanel();
  panel5.setPreferredSize(new Dimension(160,220));
  panel5.setBackground(Color.decode("#ffffe6" ));
  JPanel title3 = new JPanel();
  title3.setPreferredSize(new Dimension(510,20));
  JPanel panel6 = new JPanel();
  panel6.setPreferredSize(new Dimension(510,130));
  
  
  JPanel panel31 = new JPanel();
  JPanel panel32 = new JPanel();
  JPanel panel33 = new JPanel();
  JPanel panel34 = new JPanel();
  JPanel panel41 = new JPanel();
  JPanel panel42 = new JPanel();
  JPanel panel43 = new JPanel();
  JPanel panel44 = new JPanel();
  JPanel panel61 = new JPanel();
  JPanel panel62 = new JPanel();
  JPanel panel63 = new JPanel();


  this.add(panel,BorderLayout.EAST);
  this.add(panel2,BorderLayout.WEST);
  panel.add(title1,BorderLayout.PAGE_START);
  panel.add(panel3,BorderLayout.NORTH);
  panel.add(title2,BorderLayout.CENTER);
  panel.add(panel4,BorderLayout.SOUTH);
  panel.add(panel6);

  panel3.add(title1,BorderLayout.PAGE_START);
  panel3.add(panel31,BorderLayout.NORTH);
  panel3.add(panel32,BorderLayout.CENTER);
  panel3.add(panel33,BorderLayout.SOUTH);
  
  panel4.add(title2,BorderLayout.PAGE_START);
  panel4.add(panel42,BorderLayout.CENTER);
  panel4.add(panel43,BorderLayout.SOUTH);
  panel4.add(panel44);
  
  panel6.add(title3,BorderLayout.PAGE_START);
  panel6.add(panel62,BorderLayout.CENTER);
  panel6.add(panel63,BorderLayout.SOUTH);
  
  
  JTable mapList = new JTable(); 
   List<String> allmaps = rot.jsonList();//make this JSONLIST
    List<String[]> listMaps = new ArrayList<>();
   for (int i = 0; i < allmaps.size(); i++) {
        listMaps.add(new String[] {allmaps.get(i)});                              
   

  mapList.setModel(new DefaultTableModel(listMaps.toArray(new String[][]{}),
  new String[] {"GeoJSON maps"}));
  JTableHeader header = mapList.getTableHeader();
  
  header.setBackground(Color.decode("#ffffe6"));
  header.setForeground(Color.black);
 
 mapList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
 mapList.setAutoCreateRowSorter(true);
 mapList.setDragEnabled(true);
 mapList.setBackground(Color.decode("#f5f5f5"));
 mapList.setPreferredScrollableViewportSize(new Dimension(160, 225));
 mapList.setFillsViewportHeight( true );
 mapList.setShowGrid(false);
      }
  
 JScrollPane scrollPane = new JScrollPane(mapList);  
  

  panel2.add(scrollPane,BorderLayout.NORTH);
  JButton button = new JButton("Refresh list");
   button.setFont(font);
  button.addActionListener(q -> {
        try {
            Refresh();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | FileNotFoundException ex) {
            Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
         }});
  
   button.setSize (60,20); 
   
  panel2.add(button,BorderLayout.CENTER);
  panel2.add(panel5,BorderLayout.SOUTH);
  
  JTextField texta = new JTextField("",8);
   texta.setFont(font2);
   texta.setBackground(Color.decode("#f5f5f5"));
  //self.texta.setBorder(border)
  panel5.add(texta,BorderLayout.CENTER);
  JButton button2 =  new JButton("Delete map");
   button2.setFont(font);
  button2.addActionListener(y -> {
      try {
             rot.fileDelete(texta.getText());
         } catch (IOException ex) {
             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
         }});
  button2.setSize(60,20); 
    panel5.add(button2,BorderLayout.SOUTH);
    
    JButton button21 =  new JButton("Push to Git");
   button21.setFont(font);
  button21.addActionListener((ActionEvent y) -> {
      try {
             rot.move2git();
         } catch (IOException ex) {
             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
         }});
  button21.setSize(60,20); 
  panel5.add(button21,BorderLayout.WEST);
  

  
  JLabel label22 = new JLabel("Rename GeoJSON query");
   label22.setFont(font);
  JLabel label2 = new JLabel("Convert GeoJSON to Google map");
    label2.setFont(font);
  JLabel label3 = new JLabel("Display maps");
  label3.setFont(font);
//Renaming
  title1.add(label22);

 JTextField current = new JTextField("current name", 7);
   current.setFont(font2);
 JTextField newname = new JTextField("new name",7);
   newname.setFont(font2);
 JLabel labela =  new JLabel("input name ");
   labela.setFont(font2);
 JButton button3 = new JButton("Rename");
   button3.setFont(font);
  button3.addActionListener(yy -> {
      try {
             rot.renameMap(current.getText(),newname.getText());
         } catch (IOException ex) {
             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
         }});
 button3.setSize(60,20); 
  
  panel31.add(labela);
  panel31.add(current);
  panel32.add(newname);
  panel32.add(button3);



  title2.add(label2);
  JLabel label1 = new JLabel("input name"); 
    label1.setFont(font2);
  JTextField inmap = new JTextField("Google",7);
    inmap.setFont(font2);
  JTextField outmap = new JTextField("GeoJSON",7);
    outmap.setFont(font2);
  JButton button44 =  new JButton("Convert");
    button44.setFont(font);
    button44.setEnabled(false);
   button44.addActionListener(y -> {
      try {
 
             rot.toKML(inmap.getText(),outmap.getText());
         } catch (IOException | SQLException | InterruptedException ex) {
             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
        }});
  
  panel42.add(label1);
  panel42.add(inmap);
  panel42.add(outmap);
  panel42.add(button44);


  title3.add(label3);

  String outputs [] = {"Google list", "GeoJSON", "Google Earth"};

  JComboBox  textc = new JComboBox(outputs);
  JButton button5 = new JButton("Select");
    button5.setFont(font);
  button5.setSize(60,20);
 
 
  button5.addActionListener(jj -> { 
           String choice = (String) textc.getSelectedItem();

         if (choice.equals("GeoJSON")) {
            try{
            MapDisplay gr2 = new MapDisplay();
           gr2.toGoogle();
        } catch (IOException | InterruptedException ex) 
        {             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
          }
  
        } else if (choice.equals("Google Maps")) {
            try{
            MapDisplay gt2 = new MapDisplay();
           gt2.showgmaps();
        } catch (IOException | InterruptedException ex) 
        {             Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
          }

         } else if(choice.equals("Google list")) {
             com.thimblemill.src.ui.rsKMLList googlie = null;
               try {
                   googlie = new com.thimblemill.src.ui.rsKMLList();
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ArrayIndexOutOfBoundsException ex) {
                   Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(rMapKeeper.class.getName()).log(Level.SEVERE, null, ex);
               }
             googlie.setVisible(true);  
               }
         }
                );

  panel62.add(textc);
 
panel63.add(button5, BorderLayout.EAST);


//this.setVisible(true);
//this.show();

}
     public static void Refresh() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException, FileNotFoundException {
     rMapKeeper myApp23 = new rMapKeeper();
    myApp23.setVisible(true);
      myApp23.revalidate();
   }
//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//    mGIS myGIS = new mGIS();
//    myGIS.setVisible(true);
    
//} 

//    @Override
//    public Connection getConnection() throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getSecret() throws JsonProcessingException, IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

 
      };
