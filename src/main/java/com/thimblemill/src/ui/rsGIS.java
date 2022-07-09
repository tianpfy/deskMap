package com.thimblemill.src.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.thimblemill.src.routes.RouteMaps;
import com.thimblemill.src.routes.Stock;
import java.awt.Font;


public class rsGIS extends JFrame{
    

  public rsGIS() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, FileNotFoundException, IOException
  {
     
     super("North Queensland GIS queries");
     this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  //border = BorderFactory.createBevelBorder(BevelBorder.RAISED)
     
     this.setResizable(false);
     
  Stock rip = new Stock();
  RouteMaps ripa = new RouteMaps();
  
       Font font = new Font("Arial",Font.PLAIN,14);
      Font font2 = new Font("Arial",Font.PLAIN,14); 
      
   this.setSize(new Dimension(700,450));
  
   JPanel panel =  new JPanel();
  panel.setBackground(Color.decode("#ffffe6"));
  panel.setPreferredSize(new Dimension (530,430));
  JPanel panel2 = new JPanel();
  panel2.setPreferredSize(new Dimension(160,430));
  panel2.setBackground(Color.decode("#ffffe6"));
  JPanel title1 =  new JPanel();
  title1.setPreferredSize(new Dimension(510,20));
  JPanel panel3 = new JPanel(); 
  panel3.setPreferredSize(new Dimension(510,130));
  JPanel title2 = new JPanel();
  title2.setPreferredSize(new Dimension(510,20));
  JPanel panel4 = new JPanel();
  panel4.setPreferredSize(new Dimension(510,130));
  JPanel panel5 = new JPanel();
  panel5.setPreferredSize(new Dimension(160,220));
  panel5.setBackground(Color.decode("#ffffe6"));
  JPanel title3 = new JPanel();
  title3.setPreferredSize(new Dimension(510,20));
  JPanel panel6 = new JPanel();
  panel6.setPreferredSize(new Dimension(510,130));
  
  
  JPanel panel31 = new JPanel();
  JPanel panel32 = new JPanel();
  JPanel panel33 = new JPanel();
  JPanel panel34 = new JPanel();
  JPanel panel41 = new JPanel();
  JPanel panel42 = new JPanel();
  JPanel panel43 = new JPanel();
  JPanel panel44 = new JPanel();
  JPanel panel61 = new JPanel();
  JPanel panel62 = new JPanel();
  JPanel panel63 = new JPanel();


  this.add(panel,BorderLayout.EAST);
  this.add(panel2,BorderLayout.WEST);
  panel.add(title1,BorderLayout.PAGE_START);
  panel.add(panel3,BorderLayout.NORTH);
  panel.add(title2,BorderLayout.CENTER);
  panel.add(panel4,BorderLayout.SOUTH);
  panel.add(panel6);

  panel3.add(title1,BorderLayout.PAGE_START);
  panel3.add(panel31,BorderLayout.NORTH);
  panel3.add(panel32,BorderLayout.CENTER);
  panel3.add(panel33,BorderLayout.SOUTH);
  
  panel4.add(title2,BorderLayout.PAGE_START);
  panel4.add(panel42,BorderLayout.CENTER);
  panel4.add(panel43,BorderLayout.SOUTH);
  panel4.add(panel44);
  
  panel6.add(title3,BorderLayout.PAGE_START);
  panel6.add(panel62,BorderLayout.CENTER);
  panel6.add(panel63,BorderLayout.SOUTH);
  
  
  JTable table = new JTable(); 
   List<Object> alltabs = rip.allTables();
    List<Object[]> lister = new ArrayList<>();
      for (int i = 0; i < alltabs.size(); i++) {
        lister.add(new Object[] { 
                                  alltabs.get(i).toString().replace("[", "").replace("]", "")                                 
                              });
  table.setModel(new DefaultTableModel(lister.toArray(new Object[][]{}),
  new String[] {"Tables"}));
  JTableHeader header = table.getTableHeader();
  header.setBackground(Color.decode("#ffffe6"));
  header.setForeground(Color.black);
 
 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
 table.setAutoCreateRowSorter(true);
 table.setDragEnabled(true);
 table.setPreferredScrollableViewportSize(new Dimension(160, 225));
 table.setFillsViewportHeight( true );
  table.setBackground(Color.decode("#f5f5f5"));
 table.setShowGrid(false);
      }
  
 JScrollPane scrollPane = new JScrollPane(table);  
  
 
  panel2.add(scrollPane,BorderLayout.NORTH);
  JButton button = new JButton("Refresh list");
  button.setFont(font);
   button.addActionListener(q -> {
         try {
             Refresh();
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | FileNotFoundException ex) {
             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
         }});
   
   button.setSize (60,20); 
   
  panel2.add(button,BorderLayout.CENTER);
  panel2.add(panel5,BorderLayout.SOUTH);
  
  JTextField texta = new JTextField("",8);
   texta.setBackground(Color.decode("#f5f5f5"));
    texta.setFont(font2);
  //self.texta.setBorder(border)
  panel5.add(texta,BorderLayout.CENTER);
  JButton button2 =  new JButton("Drop table");
    button2.setFont(font);
  button2.addActionListener(y -> {
         try {
             rip.dumpTable(texta.getText());
         } catch (SQLException ex) {
             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
             }});
  button2.setSize(60,20); 
  panel5.add(button2,BorderLayout.SOUTH);
  
  

//FORM HEADINGS
  JLabel label22 = new JLabel("Intersect query");
    label22.setFont(font);
  JLabel label2 = new JLabel("Buffer query");
    label2.setFont(font);
  JLabel label3 = new JLabel("Convert table to GeoJSON");
  label3.setFont(font);
  
//INTERSECT FORM
  title1.add(label22);

 JTextField inputa = new JTextField("target", 7);
   inputa.setFont(font2);
 JTextField inputb = new JTextField("mask",7);
  inputb.setFont(font2);
 JTextField output = new JTextField("output", 7);
  output.setFont(font2);
  
 JLabel labela =  new JLabel("input tables ");  
   labela.setFont(font2);
  panel31.add(labela);
  panel31.add(inputa);
  panel31.add(inputb);
  panel32.add(output);


//BUFFER FORM
  title2.add(label2);

  JTextField distance = new JTextField("metres",7);
   distance.setFont(font2);
  JTextField intable = new JTextField("",7);
   intable.setFont(font2);
  JTextField outtable = new JTextField("output", 7);
   outtable.setFont(font2);
  JLabel label24  = new JLabel("distance");
   label24.setFont(font2);
  JLabel label1 = new JLabel("input table"); 
   label1.setFont(font2);
  
  
  panel42.add(label1);
  panel42.add(intable);
  panel42.add(label24);
  panel42.add(distance);
  
  panel44.add(outtable,BorderLayout.WEST);


//MAP FORM
  title3.add(label3);

  JTextField output3 = new JTextField("",7);
   output3.setFont(font2);
  JTextField table2 = new JTextField("",7);
   table2.setFont(font2);
  JLabel label29 = new JLabel("input table ");
    label29.setFont(font2);
  JLabel label39 = new JLabel("map name ");
    label39.setFont(font2);
  
  panel62.add(label29);
  panel62.add(table2);
  panel63.add(label39);
  panel63.add(output3);
//FUNCTIONS

JButton button3 = new JButton("Buffer");
  button3.setFont(font);
button3.addActionListener(tt -> {
   int  dist = parseInt(distance.getText());
    ripa.mBuf(dist, intable.getText(), outtable.getText());
});

button3.setSize(60,20);
panel44.add(button3);

JButton button4 = new JButton("Intersect");
  button4.setFont(font);
button4.addActionListener(ii -> {
         try {
             ripa.mInters(output.getText(), inputa.getText(), inputb.getText());
         } catch (SQLException ex) {
             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
         }
});
button4.setSize(60,20);
panel32.add(button4, BorderLayout.EAST);

JButton button5 = new JButton("Convert");
  button5.setFont(font);
button5.addActionListener(jk -> {
         try {
             ripa.outJson(table2.getText(), output3.getText());
         } catch (ClassNotFoundException | SQLException | URISyntaxException | IOException | InterruptedException ex) {
             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
         }
         
//         try {
//             ripa.move2s3();
//         } catch (IOException ex) {
//             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
//         }
         
//         try {
//             ripa.move2git(); 
//         }  catch (IOException ex) {
//             Logger.getLogger(rsGIS.class.getName()).log(Level.SEVERE, null, ex);
//         }
       });

button5.setSize(60,20);
panel63.add(button5, BorderLayout.EAST);

//this.setVisible(true);
//this.show();

  }
      public static void Refresh() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, FileNotFoundException, IOException {
      rsGIS myApp22 = new rsGIS();
    myApp22.setVisible(true);
      myApp22.revalidate();
    }
//public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//    rsGIS myGIS = new rsGIS();
//    myGIS.setVisible(true);
//   
//        
//} 
      };