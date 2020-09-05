import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Parserzz {
  public static void main(String[] args) {
    String folder = "C:\\PDF";
    File file = new File(folder);

    String ext = ".zip";
    File[] files = file.listFiles();
    Arrays.stream(files).forEach(x -> {
      int index = x.getAbsolutePath().length() - ".pdf".length();
      String name = x.getAbsolutePath().substring(0, index);
      x.renameTo(new File(name + ext));
    });
    List<String> tempString = new ArrayList<String>();
    StringBuffer sbf = new StringBuffer();

    File fielz = new File(folder);
    InputStream input;
    try {

      input = new FileInputStream(fielz);
      ZipInputStream zip = new ZipInputStream(input);
      ZipEntry entry = zip.getNextEntry();

      BodyContentHandler textHandler = new BodyContentHandler();
      Metadata metadata = new Metadata();

      Parser parser = new AutoDetectParser();

      while (entry != null) {

        if (entry.getName().endsWith(".txt") ||
            entry.getName().endsWith(".pdf") ||
            entry.getName().endsWith(".docx")) {
          System.out.println("entry=" + entry.getName() + " " + entry.getSize());
          parser.parse(input, textHandler, metadata, new ParseContext());
          tempString.add(textHandler.toString());
        }
      }
      zip.close();
      input.close();

      for (String text : tempString) {
        System.out.println("Apache Tika - Converted input string : " + text);
        sbf.append(text);
        System.out.println("Final text from all the three files " + sbf.toString());
      }
    } catch (IOException | SAXException | TikaException e) {
      e.printStackTrace();
    }
  }
}
