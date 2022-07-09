package com.thimblemill.src.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import com.thimblemill.src.routes.Stock;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JLabel;

public class rsEditor extends JFrame {
    public rsEditor()throws ClassNotFoundException, SQLException,FileNotFoundException{
        
     super("Editor");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     this.setSize(225,350);
     
     this.setResizable(false);
     this.setLayout(new GridLayout(1,3,10,0));
     
    Stock tim = new Stock();
      
      Font font = new Font("Arial",Font.PLAIN,13);
      Font font2 = new Font("Arial",Font.BOLD,10);
    
     JPanel panel = new JPanel();
     panel.setBackground(Color.decode("#ffffe6"));
    
     Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
     
     JTextField Nitem1 = new JTextField("ID number",10);
     Nitem1.setBackground(Color.decode("#f5f5f5"));
     Nitem1.setBorder(border);
    JTextField Nitem3 = new JTextField("Feature",10);
     Nitem3.setBackground(Color.decode("#f5f5f5"));
     Nitem3.setBorder(border);
      JTextField Nitem4 = new JTextField("Name",10); 
       Nitem4.setBackground(Color.decode("#f5f5f5"));
     Nitem4.setBorder(border);
     JTextField Nitem5 = new JTextField("Station",10); 
      Nitem5.setBackground(Color.decode("#f5f5f5"));
     Nitem4.setBorder(border);
      JTextField Nitem6 = new JTextField("Longitude",10);
       Nitem6.setBackground(Color.decode("#f5f5f5"));
      Nitem6.setBorder(border);
       JTextField Nitem7 = new JTextField("Latitude",10); 
        Nitem7.setBackground(Color.decode("#f5f5f5"));
      Nitem7.setBorder(border);
      
      //JLabel describa = new JLabel("See: Sources | North Queensland | Database");
     //describa.setSize(10,30);
     //describa.setFont(font2);
       // JLabel describb = new JLabel();
    // describb.setSize(10,30);
   
        
      JButton button = new JButton("Update a record");
      button.setFont(font);
     
       button.addActionListener(e -> {
           try {
                String Nummy = Nitem1.getText();
                int numbo = Integer.parseInt(Nummy);
             tim.updateRecord(Nitem4.getText(),numbo);
         } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
             Logger.getLogger(rsEditor.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
             Logger.getLogger(rsEditor.class.getName()).log(Level.SEVERE, null, ex);
         }});
         
       JButton button2 = new JButton("Add a record");
             button2.setFont(font);
        button2.addActionListener(w -> {
          try {
              
              String Nummy = Nitem1.getText();
                int numbo = Integer.parseInt(Nummy);
               String Latt = Nitem7.getText();
               float woy = Float.parseFloat(Latt);  
                 String Long = Nitem6.getText();
                 float ecks = Float.parseFloat(Long);
               
            tim.makeRecord(numbo,Nitem3.getText(),Nitem4.getText(),Nitem5.getText(),woy,ecks);
        } catch (NumberFormatException | ClassNotFoundException | SQLException ex) {
             Logger.getLogger(rsEditor.class.getName()).log(Level.SEVERE, null, ex);
         }});
       
           JButton button3 = new JButton("Delete a record");
                 button3.setFont(font);
         button3.addActionListener(y -> {
           try {
               String Nummy = Nitem1.getText();
                int numbo = Integer.parseInt(Nummy);
                
            tim.deleteRecord(numbo);
         } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
             Logger.getLogger(rsEditor.class.getName()).log(Level.SEVERE, null, ex);
         }});
         
       panel.add(button,BorderLayout.EAST);
          panel.add(button3,BorderLayout.WEST);
   panel.add(button2,BorderLayout.CENTER);  
    panel.add(Nitem1,BorderLayout.EAST);
       panel.add(Nitem3,BorderLayout.CENTER);
         panel.add(Nitem4,BorderLayout.WEST);
          panel.add(Nitem5,BorderLayout.WEST);
           panel.add(Nitem6,BorderLayout.CENTER);
             panel.add(Nitem7,BorderLayout.EAST);
           //   panel.add(describb,BorderLayout.WEST);
 //panel.add(describa,BorderLayout.EAST);
             this.add(panel);
             this.setVisible(true);
             

    }

//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//  rsEditor myMick = new rsEditor();
//   myMick.setVisible(true);
// }  

};


