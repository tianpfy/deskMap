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
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
//
//
public class projList extends JFrame {
    public projList()throws ClassNotFoundException, SQLException,FileNotFoundException{
        
     super("Other projects");
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
  
 String sources [] = {" ", "Mitchell River", "Pilbara"};
    
      JComboBox textc = new JComboBox(sources);
         JButton button5 = new JButton("Select project");
    button5.setFont(font);
  button5.setSize(60,20);
 
 
  button5.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent jj) {
           
                 String choice = (String) textc.getSelectedItem();
                
                 switch (choice) {
                     case "Mitchell River":{
                         try {
                             Desktop desktop = Desktop.getDesktop();
                             desktop.browse(new URI("https://thimblemill.com/mitchell/map.html"));
                         } catch (URISyntaxException ex) {
                             Logger.getLogger(projList.class.getName()).log(Level.SEVERE, null, ex);
                         } catch (IOException ex) {
                         Logger.getLogger(projList.class.getName()).log(Level.SEVERE, null, ex);
                     }
            
                 }
                break;

                 case "Pilbara":{
                     Desktop desktop = Desktop.getDesktop();
                     try {
                         desktop.browse(new URI("https://thimblemill.com/nqland/pilbara.html"));
                     } catch (URISyntaxException ex) {
                         Logger.getLogger(projList.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(projList.class.getName()).log(Level.SEVERE, null, ex);
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