
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
import com.thimblemill.src.models.Place;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.JTableHeader;
import com.thimblemill.src.routes.Stock;
import java.awt.Font;
import java.io.IOException;


public class rsTabPlaces extends JFrame {
    
     public rsTabPlaces() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
     super("North Queensland places");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       Font font = new Font("Arial",Font.PLAIN,14);
     //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
     setResizable(false);
     JTable bTable = new JTable();
    Stock sit2 = new Stock();
   List<Place> alls = sit2.allPlaces();
    List<Object[]> list2 = new ArrayList<>();
    for (int i = 0; i < alls.size(); i++) {
        list2.add(new Object[] { 
                                  alls.get(i).getGid(), 
                              alls.get(i).getX(), 
                             alls.get(i).getY(), 
                                  alls.get(i).getFeature(),
                                  alls.get(i).getName(),
                                   alls.get(i).getShire()
                                  
                              });

 bTable.setModel(new DefaultTableModel(list2.toArray(new Object[][]{}), 
   new String[] {"ID number", "X", "Y", "Feature", "Name","Shire"}));
    JTableHeader header = bTable.getTableHeader();
    
      header.setBackground(Color.decode("#ffffe6"));
      header.setForeground(Color.black);
       header.setFont(font);
      
 bTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
 bTable.setDragEnabled(true);
 bTable.setAutoCreateRowSorter(true);
 bTable.setBackground(Color.decode("#f5f5f5"));
 bTable.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
this.add(new JScrollPane(bTable));
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
             Logger.getLogger(rsTabPlaces.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsTabPlaces.class.getName()).log(Level.SEVERE, null, ex);
         }});
  
 JButton button2 = new JButton("Select places");
        button2.setFont(font);

      button2.addActionListener(e -> {
        try{
         rsMenu.pickShire();
          
         }  catch (ClassNotFoundException | FileNotFoundException | SQLException ex) {
             Logger.getLogger(rsTabPlaces.class.getName()).log(Level.SEVERE, null, ex);
         }});
      
      this.add(panel1,BorderLayout.WEST);
      this.add(panel2,BorderLayout.EAST);
      this.add(panel3,BorderLayout.SOUTH);
      
 
      panel3.add(button1,BorderLayout.WEST);
       panel3.add(button2,BorderLayout.EAST);
        this.pack();
       this.setVisible(true);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 }

    public static void Refresh() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
      
        rsTabPlaces myApp11 = new rsTabPlaces();
       
        myApp11.revalidate();
    }
    
//   public static void mainTable() throws ClassNotFoundException, FileNotFoundException, SQLException{
//     rsTable myApp33 = new rsTable();
//     myApp33.setVisible(true);
// };

//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//    rsTable myApp = new rsTable();
//    myApp.setVisible(true);
//         
//} 

};