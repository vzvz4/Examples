package DataBaseExample;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExternalTableMetaInformationProvider {


    public static Map<String, Column> createTableContext(TableProperties properties) {
        properties.readProperties();
        Map<String, Column> map = new LinkedHashMap<>();
        properties.getProperties().forEach((k,v) -> {

        });
        return map;
    }
}
