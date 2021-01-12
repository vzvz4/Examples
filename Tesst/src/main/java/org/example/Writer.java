package org.example;


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Writer {
   public static void main(String[] args) {
      String file = System.getProperty("user.home");
      System.out.println(file);
      Logger log = LogManager.getLogger(Writer.class);
      PropertyConfigurator.configure("log4j2.properties");
      try {
         throw new RuntimeException("OOPS!!");
      } catch (RuntimeException e) {
         log.log(Level.OFF, e);
      }
   }
}
