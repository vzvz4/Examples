package JDBC_SQLite;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseHandler implements IDataBase {
    private Connection con;
    private final String DRIVER_URL;
    private final String USER_DB_URL;
    private Statement statement;
    private String tableName;
    private Map<String, String> dbData;

    public DataBaseHandler(String tableName) {
        this.DRIVER_URL = "org.sqlite.JDBC";
        this.USER_DB_URL = "jdbc:sqlite:C:\\Users\\vorobevva\\IdeaProjects\\examples\\src\\JDBC_SQLite\\sqliteDB\\users.db";
        this.tableName = tableName;
    }

    @Override
    public String getName() {
        return tableName;
    }

    public void connect() {
        try {
            Class.forName(DRIVER_URL);
            con = DriverManager.getConnection(USER_DB_URL);
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, String> getDbData() {
        return dbData;
    }

    public void statementExecutor(Query q, String... data) {
        try {
            statement = con.createStatement();
            switch (q) {
//                case INSERT -> statement.executeQuery(Query.insert(tableName, data));
//                case SELECT -> readData(data);
//                case DELETE -> statement.executeQuery(Query.delete(tableName, data));
//                case UPDATE -> statement.executeQuery(Query.update(tableName, data));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    void readData(String... data) {
        dbData = new HashMap<>();
        try {
            ResultSet rs = statement.executeQuery(Query.select(tableName, data));
            while (rs.next()) {
                dbData.put(rs.getString(2),rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
