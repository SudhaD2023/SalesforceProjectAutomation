package com.automation.tests.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
   private FileInputStream stream=null;
   private Properties propFile=null;
   
   public Properties loadFile(String filename) {
	   propFile=new Properties();
	   String propertyFilePath=null;
	   switch(filename) {
	   case "applicationDataProperties":
		   propertyFilePath=constants.APPLICATION_PROPERTIES;
		   break;
		   default:System.out.println("no correct keyword entered");
		   }
	   try {
		   stream=new FileInputStream(propertyFilePath);
		   propFile.load(stream);
	   }catch(FileNotFoundException e) {
		   e.printStackTrace();
	   } catch (IOException e) {
		e.printStackTrace();
	}
	   return propFile;
   }
   
   public String getPropertyValue(String Key) {
	   String value=propFile.getProperty(Key);
	   return value;
   }
   
   public void writeDataToPropertyFile(File path,String key,String value) {
	   Properties propFile=new Properties();
	   propFile.setProperty(key, value);
	   try {
	   propFile.store(new FileOutputStream(path), "updateing data");
	   }catch (IOException e) {
		   e.printStackTrace();
	   }
   }
}
