package JDBC_SQLite;

enum Query {
    INSERT("INSERT INTO"),
    UPDATE("UPDATE"),
    DELETE("DELETE FROM"),
    SELECT("SELECT");

    private String msg;

    Query(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static String update(String tableName, String[] data) {
        System.out.println("Updated");
        return String.format("UPDATE %s SET %s WHERE %s", tableName, data[0], data[1]);
    }

    public static String select(String tableName, String... data) {
        System.out.println("Selected");
        return (data.length == 1) ? String.format("SELECT %s FROM %s", data[0], tableName) :
                String.format("SELECT %s FROM %s WHERE %s", data[0], tableName, data[1]);
    }

    public static String insert(String tableName, String... data) {
        System.out.println("Raw inserted");
        return String.format("%s %s (%s, %s) VALUES ('%s','%s')",
                Query.INSERT.getMsg(), tableName, data[0], data[1], data[2], data[3]);
    }

    public static String delete(String tableName, String... data) {
        System.out.println("Raw deleted");
        return "DELETE " + tableName + " WHERE " + data[0];
    }
}