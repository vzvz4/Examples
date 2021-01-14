package DataBaseExample;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {
    private Map<String, Column> tableContext;
    private String name;

    public Table(String name, Map<String, Column> tableContext) {
        this.name = name;
        this.tableContext = tableContext;
    }

    public Table(TableProperties properties) {
        this.name = properties.getName();
        tableContext = new LinkedHashMap<>();
        tableContext = ExternalTableMetaInformationProvider.createTableContext(properties);
    }

}
