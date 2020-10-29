package Patterns.Structural.Decorator;

import java.io.*;

public class FileDataSource implements DataSource {
    private File file;
    private BufferedWriter bw;
    private BufferedReader br;

    public FileDataSource(File filename) {
        file = filename;
        try {
            bw = new BufferedWriter(new FileWriter(filename));
            br = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeData(String data) throws IOException {
        bw.write(data);
        bw.flush();
    }

    @Override
    public String  readData() throws IOException {
        System.out.println(file.getAbsolutePath());
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
}
