package DataBaseExample;

public class Column {
    private Type type;
    private String columnName;

    public Column(String columnName, Type type) {
        this.type = type;
        this.columnName = columnName;
    }

    public Type getType() {
        return type;
    }

    public String getColumnName() {
        return columnName;
    }
}
