package com.thimblemill.src.ui;

//
import com.thimblemill.src.routes.MapDisplay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
//
//
public class tableList extends JFrame {
    public tableList()throws ClassNotFoundException, SQLException,FileNotFoundException{
        
     super("Project data");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     this.setSize(500,120);
        
     this.setResizable(false);
     this.setLayout(new BorderLayout());
    this.setBackground(Color.BLACK);
        
     Font font = new Font("Arial",Font.PLAIN,14);
      //Font font2 = new Font("Arial",Font.PLAIN,11);
     
     JPanel panel = new JPanel();
   panel.setBackground(Color.decode("#ffffe6"));
     panel.setSize(500,100);
     
     //Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
  
 String sources [] = {"Sites", "Places"};
    
      JComboBox textc = new JComboBox(sources);
         JButton button5 = new JButton("Select table");
    button5.setFont(font);
  button5.setSize(60,20);
 
 
  button5.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent jj) {
           
                 String choice = (String) textc.getSelectedItem();
                
                 switch (choice) {
                     case "Sites":
                     {  rsMenu tt3;
                         try {
                             tt3 = new rsMenu();
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (SQLException ex) {
                             Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (IOException ex) {
                             Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     try {
                         rsMenu.showTable();
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (InstantiationException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     }
                          
                 }
                break;

                 case "Places":{
                     
                    
                     try {
                         rsMenu  tt2 = new rsMenu();
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  
                   
                     try {
                         rsMenu.showPlaces();
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(tableList.class.getName()).log(Level.SEVERE, null, ex);
                     }
}
     break;

             default:
                 break;
         }

    }
      });      
    panel.add(textc,BorderLayout.EAST);
    panel.add(button5,BorderLayout.WEST );
    
     this.add(panel);
             this.setVisible(true);
           
    }
//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//  tableList myDicky = new tableList();
//   myDicky.setVisible(true);

//}
};