
package com.thimblemill.src.ui;

import com.thimblemill.src.interfaces.Mappable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import com.thimblemill.src.routes.MapDisplay;
import java.awt.Insets;
import javax.swing.WindowConstants;


public class rsMenu extends JFrame {
    public rsMenu()throws ClassNotFoundException, SQLException, InterruptedException, FileNotFoundException, IOException {
    
        super ("NQ pastoral heritage");
          // setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     setResizable(false);
    
     this.setSize(900,550);
     BorderLayout packit = new BorderLayout();
     this.setLayout(packit);
     Border border = BorderFactory.createEmptyBorder(30, 30, 30, 30);
      
     Font font = new Font("Arial",Font.PLAIN,14);
     
      JToolBar tbar = new JToolBar();
     tbar.setBackground(Color.decode("#ffffe6"));
     tbar.setForeground(Color.black);
     tbar.setSize(950,40);
     this.add(tbar,BorderLayout.NORTH);
     
     
     JTextArea txt = new JTextArea();
     txt.setSize(400,500);
     txt.setEditable(false);
     txt.setWrapStyleWord(false);
     txt.setLineWrap(false);   
    
     txt.setFont(font);
     txt.setBackground(Color.decode("#f5f5f5"));
     txt.setForeground(Color.BLACK);
       txt.setMargin(new Insets(10, 100, 0, 0)); 
     
     JScrollPane scroller = new JScrollPane(txt);
     this.add(scroller,BorderLayout.CENTER);
   
     FileReader reader = new FileReader("beginr.txt");
     txt.read(reader, "");
    
      JButton button1 = new JButton("Sites");
      button1.setForeground(Color.black);
      button1.setBackground(Color.decode("#ffffe6"));
      button1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
      button1.setFont(font);
      button1.addActionListener((ActionEvent e) -> {
         try {
             showTable();
         } catch (ClassNotFoundException | FileNotFoundException | SQLException ex) {
             Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  catch (InstantiationException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            }});
         
 JButton button10 = new JButton("Query data");
      button10.addActionListener((ActionEvent h)->{
            try {
                showSource();
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | ArrayIndexOutOfBoundsException | IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
      });
      
       
     
      JButton button2 = new JButton("Places");
      button2.setForeground(Color.black);
      button2.setBackground(Color.decode("#ffffe6"));
       button2.setFont(font);
       button2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
      button2.addActionListener((ActionEvent e) -> {
          try{
        rsMenu.showPlaces();
            
      }

  catch (ClassNotFoundException | FileNotFoundException | SQLException ex) {
             Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  catch (IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            }});
    

         
      JButton button3 = new JButton("Edit sites");
      button3.addActionListener((ActionEvent e) -> {
         try {
             showEditor();
         } catch (ClassNotFoundException | FileNotFoundException | SQLException ex) {
             Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
         }});

      
         JButton button4 = new JButton("GIS");
         button4.addActionListener((ActionEvent f) -> {
         try {
             showGIS();
         } catch (ClassNotFoundException | FileNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
             Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
         }  catch (IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            }});
         
     
      
         JButton button5 = new JButton("Map manager");
         button5.setEnabled(false);
         button5.addActionListener((ActionEvent f) -> {
         try {
             mapList();
         } catch (ClassNotFoundException | FileNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
             Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ArrayIndexOutOfBoundsException | IOException ex) {
             Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
         }});
         
  
       
     JButton button66 = new JButton("Sources");
     button66.addActionListener((ActionEvent g)->{
      MapDisplay jon = new MapDisplay();
            try {
                jon.Sources();
            } catch (IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            
            }});
     
              JButton button6 = new JButton("View maps");
     button6.addActionListener((ActionEvent g)->{
      MapDisplay jon = new MapDisplay();
            try {
                jon.projectMaps();
            } catch (IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
});
     
//                   JButton button99 = new JButton("Related projects");
//         button99.addActionListener((ActionEvent g)->{
//      MapDisplay jono = new MapDisplay();
//            try {
//                jono.mitchellMaps();
//            } catch (IOException ex) {
//                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
//            }
//});
         
                            JButton button99 = new JButton("Related projects");
         button99.addActionListener((ActionEvent g)->{
            try {
                showProjects();
                

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(rsMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
});
  
   tbar.addSeparator(new Dimension(25,45));
   tbar.addSeparator(new Dimension(10,40));
     tbar.add(button66);  
     tbar.addSeparator(new Dimension(40,40));
   tbar.add(button6);  
   tbar.addSeparator(new Dimension(60,45));
   tbar.add(button10); 
   //tbar.addSeparator(new Dimension(60,45));
   //tbar.add(button2);
 //tbar.addSeparator(new Dimension(80,45));
  // tbar.add(button7);
    tbar.addSeparator(new Dimension(60,45));
   tbar.add(button3); 
   tbar.addSeparator(new Dimension(60,45));
   tbar.add(button4); 
   tbar.addSeparator(new Dimension(40,45));
    tbar.add(button5); 
     tbar.addSeparator(new Dimension(40,45));
    tbar.add(button99); 
   
 }
    
    public static void showTable() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IOException{
        com.thimblemill.src.ui.rsTable myApp3 = new com.thimblemill.src.ui.rsTable();
    myApp3.setVisible(true);
    }; 
    
 public static void pickPlace() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
        com.thimblemill.src.ui.rsSelector myPick = new com.thimblemill.src.ui.rsSelector();
    myPick.setVisible(true);
    }; 

     public static void pickShire() throws ClassNotFoundException, FileNotFoundException, SQLException{
        com.thimblemill.src.ui.rsSelector2 myPicka = new com.thimblemill.src.ui.rsSelector2();
    myPicka.setVisible(true);
    }; 
    
     public static void showPlaces() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
        com.thimblemill.src.ui.rsTabPlaces myApp31 = new com.thimblemill.src.ui.rsTabPlaces();
    myApp31.setVisible(true);
    }; 
   
     public static void showAssets() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IOException{
        rsTable myApp39 = new rsTable();
    myApp39.setVisible(true);
    }; 
        
   public static void showEditor() throws ClassNotFoundException, FileNotFoundException, SQLException{
    rsEditor myRick = new rsEditor();
    myRick.setVisible(true);
    }; 
   
    public static void showGIS() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
    rsGIS myPick = new rsGIS();
    myPick.setVisible(true);
    }; 
    
    public  static void mapList() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IllegalAccessException, ArrayIndexOutOfBoundsException, IOException{
   rMapKeeper myMaps = new rMapKeeper();
    myMaps.setVisible(true);
    };
    
     public  static void showSource() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IllegalAccessException, ArrayIndexOutOfBoundsException, IOException{
com.thimblemill.src.ui.tableList mySources = new com.thimblemill.src.ui.tableList();
    mySources.setVisible(true);
    };
     
      public  static void showProjects() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IllegalAccessException, ArrayIndexOutOfBoundsException, IOException{
com.thimblemill.src.ui.projList myProjs = new com.thimblemill.src.ui.projList();
    myProjs.setVisible(true);
    };

 // public  static void showComposer() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IllegalAccessException, ArrayIndexOutOfBoundsException, IOException{
 // com.thimblemill.src.ui.rsComposer myPad = new  com.thimblemill.src.ui.rsComposer(); 
   // myPad.setVisible(true);
    //};

public static void main(String[] args) throws ClassNotFoundException, InterruptedException, SQLException, FileNotFoundException, IOException {
    rsMenu myMnu = new rsMenu();
   myMnu.setVisible(true);
   //myMnu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   } 

};