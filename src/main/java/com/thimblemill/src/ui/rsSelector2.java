package com.thimblemill.src.ui;


import com.thimblemill.src.routes.RouteMaps;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import com.thimblemill.src.routes.Stock;
import java.awt.Font;


public class rsSelector2 extends JFrame {
    public rsSelector2()throws ClassNotFoundException, SQLException,FileNotFoundException{
        
     super("Select places by Shire name or by place name");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     this.setSize(500,150);
       
     setResizable(false);
     this.setLayout(new BorderLayout());
    this.setBackground(Color.decode("#ffffe6"));
        
     Font font = new Font("Arial",Font.PLAIN,14);
      Font font2 = new Font("Arial",Font.PLAIN,14);
     
     Stock jim = new Stock();
     RouteMaps jake = new RouteMaps();
      
     JPanel panel = new JPanel();
   panel.setBackground(Color.decode("#ffffe6"));
     //panel.setSize();
     
     JPanel panel2 = new JPanel();
     panel2.setBackground(Color.decode("#ffffe6"));
      //panel2.setSize();
      
//       JPanel panel3 = new JPanel();
//     panel3.setBackground(Color.decode("#ffffe6"));
//      panel3.setSize(500,20);
    
     Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);

    
    Vector<String> shires = jim.allShires();
    
      JComboBox mname = new JComboBox(shires);
       mname.addActionListener(e -> {});
       
     JTextField placename = new JTextField("output table",10); 
     placename.setBorder(border);
     
     JButton button = new JButton("Save");
     button.setFont(font2);
         button.addActionListener(y -> {
         try {
             jake.copyShires(placename.getText(), (String) mname.getSelectedItem());
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(rsSelector2.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(rsSelector2.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsSelector2.class.getName()).log(Level.SEVERE, null, ex);
         }
});
       
                  JTextField name = new JTextField ("place name", 8);
                  name.setFont(font2);
          JTextField outname = new JTextField("output table",10); 
             outname.setFont(font2);
            JButton button2 = new JButton("Save");
              button2.setFont(font2);
          button2.addActionListener(y -> {
         try {
        
            
             jim.getLocation2(outname.getText(),name.getText());
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(rsSelector2.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(rsSelector2.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsSelector2.class.getName()).log(Level.SEVERE, null, ex);
         }
});     
          
             
    JPanel panel3 = new JPanel();      
       panel3.setBackground(Color.decode("#ffffe6"));
       
    panel.add(mname,BorderLayout.EAST);
    panel.add(placename,BorderLayout.CENTER);
    panel.add(button,BorderLayout.WEST );
    
      panel2.add(name,BorderLayout.EAST);
    panel2.add(outname,BorderLayout.CENTER);
    panel2.add(button2,BorderLayout.WEST );
    
 
     this.add(panel, BorderLayout.NORTH);
              this.add(panel2, BorderLayout.CENTER);
     panel2.setBackground(Color.decode("#ffffe6"));
    
        
               this.add(panel3, BorderLayout.SOUTH);
             this.setVisible(true);
           
    }
//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//  rsSelector2 myMick = new rsSelector2();
//   myMick.setVisible(true);
//}
};