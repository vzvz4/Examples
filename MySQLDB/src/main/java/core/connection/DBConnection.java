package core.connection;

import core.ConfigParams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbsConnection {
    protected String port;
    protected String host;
    protected String user;
    protected String pass;

    protected String urlParams;
    protected String dbName;

    protected String urlPrefix;

    public AbsConnection() {
        port = ConfigParams.getConfig().getPort();
        host = ConfigParams.getConfig().getHost();
        user = ConfigParams.getConfig().getUserName();
        pass = ConfigParams.getConfig().getUserPass();
        dbName = ConfigParams.getConfig().getDbName();
        urlParams = ConfigParams.getConfig().getParams();
    }

    protected String createURL() {
        return urlPrefix + host + ":" + port + "/" + dbName + urlParams;
    }

    public Connection createConn() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(createURL(), user, pass);
    }

}
