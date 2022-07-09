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
import java.io.IOException;
import java.util.logging.Level;
//
//
public class sourceList extends JFrame {
    public sourceList()throws ClassNotFoundException, SQLException,FileNotFoundException{
        
     super("Project data");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     this.setSize(500,120);
        
     this.setResizable(false);
     this.setLayout(new BorderLayout());
    this.setBackground(Color.BLACK);
        
     Font font = new Font("Arial",Font.PLAIN,14);
      //Font font2 = new Font("Arial",Font.PLAIN,11);
     
     //Stock jim = new Stock();
      
     JPanel panel = new JPanel();
   panel.setBackground(Color.decode("#ffffe6"));
     panel.setSize(500,100);
     
     //Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
  
 String sources [] = {"North Queensland", "Mitchell", "Pilbara"};
    
      JComboBox textc = new JComboBox(sources);
         JButton button5 = new JButton("Select");
    button5.setFont(font);
  button5.setSize(60,20);
 
 
  button5.addActionListener(jj -> { 
           String choice = (String) textc.getSelectedItem();
         switch (choice) {
             case "Mitchell":
                 MapDisplay gt3 = new MapDisplay();
               {
                //   try {
                  //     gt3.showkmaps();
                   //} catch (IOException ex) {
                     //  Logger.getLogger(sourceList.class.getName()).log(Level.SEVERE, null, ex);
                   //}
               }
                 break;

            case "Pilbara":
                 //try{
                   //  MapDisplay gr2 = new MapDisplay();
                     //gr2.toGoogle();
                 //} catch (IOException | InterruptedException ex)
                 { //            Logger.getLogger(sourceList.class.getName()).log(Level.SEVERE, null, ex);
                 }   
                 break;
                 
                 
             case "North Queensland":
                 MapDisplay gt2 = new MapDisplay();
               {
                   try {
                       gt2.Sources();
                   } catch (IOException ex) {
                       Logger.getLogger(sourceList.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InterruptedException ex) {
                   Logger.getLogger(sourceList.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
                 break;

             default:
                 break;
         }

    });
            
    panel.add(textc,BorderLayout.EAST);
    panel.add(button5,BorderLayout.WEST );
    
     this.add(panel);
             this.setVisible(true);
           
    }
public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
  sourceList myDick = new sourceList();
   myDick.setVisible(true);

}};