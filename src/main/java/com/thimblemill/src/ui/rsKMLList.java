package com.thimblemill.src.ui;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.WindowConstants;
import javax.swing.table.JTableHeader;
import com.thimblemill.src.routes.RouteMaps;
import java.awt.Font;

public class rsKMLList  extends JFrame{
    
      Font font = new Font("Arial",Font.PLAIN,14);
      Font font2 = new Font("Arial",Font.PLAIN,11); 
    public rsKMLList()throws ClassNotFoundException,NoSuchFileException, ArrayIndexOutOfBoundsException, SQLException, FileNotFoundException, IOException {
     super("Google maps");
    
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setSize(180,500);
    this.setResizable(false);
    
    RouteMaps will = new RouteMaps();

JTable mapList  = new JTable();
   List<String> allmaps = will.kmlList();
     List<String[]> listMaps = new ArrayList<>();
    for (int i = 0; i < allmaps.size(); i++) {
        listMaps.add(new String[] { 
                                  allmaps.get(i) });
        
  mapList.setModel(new DefaultTableModel(listMaps.toArray(new String[][]{}),
  new String[] {"Google maps"}));
  JTableHeader header = mapList.getTableHeader();
  header.setBackground(Color.decode("#ffffe6"));
  header.setForeground(Color.black);                            
                              
  mapList.setAutoCreateRowSorter(true);
  mapList.setDragEnabled(true);
  mapList.setPreferredScrollableViewportSize(new Dimension(160, 250));
  mapList.setFillsViewportHeight(true);
  mapList.setShowGrid(false);

  JScrollPane spane = new JScrollPane(mapList);         
  spane.setPreferredSize(new Dimension(150,350));
  spane.setBackground(Color.decode("#ffffe6")); 
  
  JPanel panel = new JPanel();
  panel.setPreferredSize(new Dimension(180,350)); 
  panel.setBackground(Color.decode("#ffffe6"));
  panel.add(spane);
  
  JPanel panel30 = new JPanel();
  panel30.setPreferredSize(new Dimension(180,75));
  panel30.setBackground(Color.decode("#ffffe6"));
  JPanel panel50 = new JPanel();
  panel50.setPreferredSize(new Dimension(180,75));
  panel50.setBackground(Color.decode("#ffffe6"));

  this.add(panel,BorderLayout.NORTH);
  this.add(panel30,BorderLayout.CENTER);
  this.add(panel50,BorderLayout.SOUTH);

  JButton btn =  new JButton("Refresh list");
btn.setFont(font);
  btn.addActionListener(q -> {
         try {
             Refresher();
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | FileNotFoundException ex) {
             Logger.getLogger(com.thimblemill.src.ui.rsGIS.class.getName()).log(Level.SEVERE, null, ex);
         }  catch (ArrayIndexOutOfBoundsException | IOException ex) {
                Logger.getLogger(rsKMLList.class.getName()).log(Level.SEVERE, null, ex);
            }});
  panel30.add(btn);
  
  JTextField texta = new JTextField("",8);
texta.setFont(font2);
  panel50.add(texta,BorderLayout.CENTER);
  JButton btn2 = new JButton("Delete map");
btn2.setFont(font);
  btn.addActionListener(h -> {
            try {
                will.kmlDelete(texta.getText());
            } catch (IOException ex) {
                Logger.getLogger(rsKMLList.class.getName()).log(Level.SEVERE, null, ex);
            }
});
  
  panel50.add(btn2,BorderLayout.WEST);
 
//this.setVisible(true);
//this.show();
  }}
     public static void Refresher() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, FileNotFoundException, ArrayIndexOutOfBoundsException, IOException {
     rsKMLList myMaps2 = new rsKMLList();
    //myMaps2.repaint();
    myMaps2.setVisible(true);
    }

//public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException,  IllegalAccessException, SQLException {
//    rsMapList myMap = new rsMapList();
//   myMap.setVisible(true);
//}
      };


    
     
     
     
     
     
 
   