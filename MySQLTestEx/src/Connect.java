import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbName = "web_app";
        String url = "jdbc:mysql://127.0.0.1:3306/"+dbName+"?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
        Connection con = DriverManager.getConnection(url,"owpk","178UeeE34");
        System.out.println("connected");
        Statement st = con.createStatement();
        //allowPublicKeyRetrieval=true

        //второй способ
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL( false );
        dataSource.setServerTimezone( serverTimeZone );
        dataSource.setServerName( serverName );
        dataSource.setDatabaseName( databaseName );
        dataSource.setPortNumber( portNumber );
        dataSource.setUser( user );
        dataSource.setPassword( password );

        return dataSource.getConnection();
        //st.executeQuery("");
    }
}
