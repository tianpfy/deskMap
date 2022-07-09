
package com.thimblemill.src.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface Mappable {

    
static final String BASEDIR = System.getProperty("user.dir");
static final String TXTFILE = "resources/beginr.txt";

public  void showmaps();
public  void showgmaps() throws  FileNotFoundException, IOException, InterruptedException;
public void toGoogle ()throws  FileNotFoundException, IOException, InterruptedException;   

};
