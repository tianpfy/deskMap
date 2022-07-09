
package com.thimblemill.src.routes;


//import com.thimblemill.mapvue.interfaces.Mappable;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.FileNotFoundException;


public class MapDisplay {


 public  void showgmaps() throws  FileNotFoundException, IOException, InterruptedException{


        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://earth.google.com/web/@0,0,0a,22251752.77375655d,35y,0h,0t,0r"));
            } catch (IOException | URISyntaxException e) {
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("start" + "https://earth.google.com/web/@0,0,0a,22251752.77375655d,35y,0h,0t,0r");
            } catch (IOException e) {
            }
       }}



public void toGoogle() throws  FileNotFoundException, IOException, InterruptedException{
  
    
    if(Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
        try {
            // desktop.browse(new URI(prop.getProperty("GEOJSON")));
            desktop.browse(new URI("https://geojson.io/#map=2/20.0/0.0"));
        } catch (IOException | URISyntaxException e) {
        }
    }else{
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("start" +"https://geojson.io/#map=2/20.0/0.0" );
        } catch (IOException e) {
        }
    }}

 public void Sources() throws  FileNotFoundException, IOException, InterruptedException{
  
    
    if(Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
        try {
            // desktop.browse(new URI(prop.getProperty("GEOJSON")));
            desktop.browse(new URI("https://thimblemill.com/nqland/stockRoutes.html"));
        } catch (IOException | URISyntaxException e) {
        }
    }else{
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("start" +"https://thimblemill.com/stockRoutes.html" );
        } catch (IOException e) {
        }
    }}
    
        public void projectMaps() throws  FileNotFoundException, IOException, InterruptedException{
  
    
    if(Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
        try {
            // desktop.browse(new URI(prop.getProperty("GEOJSON")));
            desktop.browse(new URI("https://thimblemill.com/nqland/map.html"));
        } catch (IOException | URISyntaxException e) {
        }
    }else{
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("start" +"https://thimblemill.com/nqland/map.html" );
        } catch (IOException e) {
        }
    
      }}
            public void mitchellMaps() throws  FileNotFoundException, IOException, InterruptedException{
  
    
    if(Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
        try {
            // desktop.browse(new URI(prop.getProperty("GEOJSON")));
            desktop.browse(new URI("https://thimblemill.com/mitchell/map.html"));
        } catch (IOException | URISyntaxException e) {
        }
    }else{
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("start" +"https://thimblemill.com/mitchell/map.html" );
        } catch (IOException e) {
        }
    }
    }}
   
    
