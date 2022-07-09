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

public class rsSelector extends JFrame {
    
    public rsSelector()throws ClassNotFoundException, SQLException,FileNotFoundException, IOException{
        
     super("Select sites by station name or by site ID");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     
     this.setSize(500,150);
     
     setResizable(false);
     this.setLayout(new BorderLayout(80,80));
     
     Stock tina = new Stock();
     RouteMaps tint = new RouteMaps();
      
     JPanel panel = new JPanel();
    //  panel.setBounds(100,100,450,200);
     panel.setBackground(Color.decode("#ffffe6"));    
     Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
      
       Stock tita = new Stock();
       
         Font font = new Font("Arial",Font.PLAIN,14);
      Font font2 = new Font("Arial",Font.PLAIN,14);
      
    Vector<String> Allstations = tita.allStations();
    
      JComboBox mname = new JComboBox(Allstations);
       mname.addActionListener(e -> {});
       
     JTextField placename = new JTextField("output table",10); 
     placename.setBorder(border);
     placename.setFont(font2);
     
     JButton button = new JButton("Save");
        button.setFont(font2); 
         button.addActionListener(y -> {
         try {
             tint.copyStations(placename.getText(), (String) mname.getSelectedItem());
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(rsSelector.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(rsSelector.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsSelector.class.getName()).log(Level.SEVERE, null, ex);
         }
});
         
         JTextField idnum = new JTextField ("id number", 8);
          idnum.setFont(font2);
          JTextField outname = new JTextField("output table",10); 
           outname.setFont(font2);
         JButton button2 = new JButton("Save");
          button2.setFont(font2);
                   button2.addActionListener(y -> {
         try {
             String idn = idnum.getText();
             Integer idvalue = Integer.parseInt(idn);
             tina.getLocation(outname.getText(),idvalue);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(rsSelector.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(rsSelector.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsSelector.class.getName()).log(Level.SEVERE, null, ex);
         }
});   
         JPanel panel2 = new JPanel();
    //      panel2.setBounds(100,100,450,200);
          JPanel panel3 = new JPanel();
          
   panel.add(mname,BorderLayout.EAST);
    panel.add(placename,BorderLayout.CENTER);
    panel.add(button,BorderLayout.WEST );
 panel2.add(idnum, BorderLayout.WEST);
  panel2.add(outname, BorderLayout.CENTER);
   panel2.add(button2, BorderLayout.EAST);
  panel2.setBackground(Color.decode("#ffffe6"));
 panel3.add(panel,BorderLayout.NORTH);   
  panel3.add(panel2,BorderLayout.SOUTH); 
     panel3.setBackground(Color.decode("#ffffe6"));
     
             this.add(panel3);
             this.setVisible(true);
         //    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
//rsSelector myMick = new rsSelector();
// myMick.setVisible(true);
//}
};