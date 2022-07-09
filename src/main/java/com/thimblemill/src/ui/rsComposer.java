package com.thimblemill.src.ui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//import javax.swing.WindowConstants;
//import com.thimblemill.src.routes.RouteMaps;
//import com.thimblemill.src.routes.Stock;

//public class rsComposer extends JFrame {

   // public rsComposer()throws ClassNotFoundException, SQLException, FileNotFoundException{
        
//  
//     super("North Queensland query composer");
//     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//     this.setSize(500,500);
//     
//    RouteMaps jim = new RouteMaps();
//    Stock jon = new Stock();
//    
//     JTextArea tableau =  new JTextArea();
//     tableau.setSize(450,450);
//     JScrollPane pain = new JScrollPane();
//     pain.add(tableau);
// 
//     Font font = new Font("Ariel",Font.BOLD,10);
//     tableau.setFont(font);
//     tableau.setForeground(Color.BLACK);
//     tableau.setBackground(Color.decode("#f5f5f5"));
//     tableau.setColumns(6);
//     tableau.setEditable(true);
//     tableau.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
//     
//     JPanel panel = new JPanel();
//     panel.setBackground(Color.decode("#ffffe6"));
//     panel.setSize(40,500);
//     JPanel panel2 = new JPanel();
//     panel2.setBackground(Color.decode("#ffffe6"));
//     panel2.setSize(4,500);
//     JPanel panel3 = new JPanel();
//     panel3.setBackground(Color.decode("#ffffe6"));
//     panel3.setSize(40,500);
//     JPanel panel4 = new JPanel();
//     panel4.setBackground(Color.decode("#ffffe6"));
//     panel4.setSize(40,500);
//     
//  this.add(panel2,BorderLayout.NORTH);
//  this.add(pain,BorderLayout.CENTER);
//  this.add(panel,BorderLayout.SOUTH);
//  this.add(panel3,BorderLayout.EAST);
//  this.add(panel4,BorderLayout.WEST);
//  
// JTextField textd  = new JTextField(" Table name",12);
//  textd.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
//
//
//JButton button4 = new JButton("Save to table");
//  button4.addActionListener(e -> {
//        try {
//             jim.fileWriter(tableau.getText());
//         } catch (IOException ex) {
//             Logger.getLogger(rsComposer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      try {
//            jon.newTable(textd.getText());
//        } catch (ClassNotFoundException | SQLException  ex) {
//            Logger.getLogger(rsComposer.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {   
//             Logger.getLogger(rsComposer.class.getName()).log(Level.SEVERE, null, ex);
//         }   
//        
//});
//  
//   panel.add(button4,BorderLayout.EAST);
//  panel.add(textd, BorderLayout.WEST);
//this.pack();
//this.setVisible(true);
////this.show();
// }
// 
////public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//  //rsComposer myPlate = new rsComposer();
//   //myPlate.setVisible(true);

//});