
package com.thimblemill.src.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.thimblemill.src.models.Assets;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.JTableHeader;
import com.thimblemill.src.routes.Stock;
import java.awt.Font;
import java.io.IOException;


public class rsTable extends JFrame {

    public rsTable()throws ClassNotFoundException, SQLException, FileNotFoundException, InstantiationException, IOException {
     super("North Queensland sites");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     Font font = new Font("Arial",Font.PLAIN,14);
      
     this.setResizable(false);
     JTable aTable = new JTable();
    Stock sit = new Stock();
   
   List<Assets> allstuff = sit.allRecords();
    List<Object[]> list = new ArrayList<>();
    for (int i = 0; i < allstuff.size(); i++) {
        list.add(new Object[] { 
                                  allstuff.get(i).getGid(), 
                                  allstuff.get(i).getX(),
                                  allstuff.get(i).getY(), 
                                  allstuff.get(i).getFeature(),
                                  allstuff.get(i).getName(),
                                   allstuff.get(i).getStation()
                              });

 aTable.setModel(new DefaultTableModel(list.toArray(new Object[][]{}), 
   new String[] {"ID number", "X", "Y", "Feature","Name", "Station"}));
    JTableHeader header = aTable.getTableHeader();
      header.setBackground(Color.decode("#ffffe6"));
      header.setForeground(Color.black);
       header.setFont(font);
       
 aTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
 aTable.setDragEnabled(true);
 aTable.setAutoCreateRowSorter(true);
 aTable.setBackground(Color.decode("#f5f5f5"));
 aTable.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
this.add(new JScrollPane(aTable));
    }
    
     JPanel panel1 = new JPanel();
     panel1.setBackground(Color.decode("#ffffe6"));
       JPanel panel2 = new JPanel();
     panel2.setBackground(Color.decode("#ffffe6"));
         JPanel panel3 = new JPanel();
     panel3.setBackground(Color.decode("#ffffe6"));
  
     
     JButton button1 = new JButton("Refresh");
      button1.setFont(font);
      button1.addActionListener(e -> {
         try {
             Refresh();
         } catch (ClassNotFoundException | FileNotFoundException | SQLException ex) {
             Logger.getLogger(rsTable.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(rsTable.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsTable.class.getName()).log(Level.SEVERE, null, ex);
         }});
  
    
      JButton button2 = new JButton("Select sites");
      button2.setFont(font);
        button2.addActionListener(e -> {
         try {
              rsMenu.pickPlace();
          } catch (ClassNotFoundException | FileNotFoundException | SQLException ex) {
              Logger.getLogger(rsTable.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
             Logger.getLogger(rsTable.class.getName()).log(Level.SEVERE, null, ex);
         }});

      this.add(panel1,BorderLayout.WEST);
      this.add(panel2,BorderLayout.EAST);
      this.add(panel3,BorderLayout.SOUTH);
      
    
      panel3.add(button1,BorderLayout.WEST);
     panel3.add(button2,BorderLayout.EAST);
     this.pack();
       this.setVisible(true);

 }


 public static void Refresh() throws ClassNotFoundException, FileNotFoundException, SQLException, InstantiationException, IOException{
        rsTable myApp9 = new rsTable();
        myApp9.revalidate();
    }
    

//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//    rsTable myApp = new rsTable();
//    myApp.setVisible(true);
//         
//} 

};