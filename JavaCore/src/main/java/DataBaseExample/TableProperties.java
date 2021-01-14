package DataBaseExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableProperties {
    private Map<String, String> properties;
    private String file;
    private String tableName;

    public TableProperties(String tablePath) {
        file = tablePath;
        properties = new LinkedHashMap<>();
    }

    public void readProperties() {
        boolean startFound = false;
        int lineCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String current = reader.readLine().trim();
                if (current.equals("{") && startFound)
                    throw new RuntimeException("Unexpected character at line: " + lineCount);
                else if (current.equals("{")) {
                    startFound = true;
                    continue;
                } else if (current.isEmpty()) {
                    continue;
                }
                if (startFound) {
                    if (current.equals("}")) break;
                    String[] keyVal = current.split(":");
                    if (keyVal.length < 2) {
                        throw new RuntimeException("Unexpected arguments at line: " + lineCount);
                    }
                    properties.put(keyVal[0], keyVal[1]);
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return properties.get(key);
    }

    public void put(String key, String val) {
        properties.put(key, val);
    }

    public int getSize() {
        return properties.size();
    }

    public String getName() {
        return tableName;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}



































