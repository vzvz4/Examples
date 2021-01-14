package org.example;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class Reader {

   public static void main(String[] args) {
       String a = "asd =";
       System.out.println(a.substring(0, a.indexOf('=')));
       System.out.println(a.substring(a.indexOf('=') + 1));
   }
}
