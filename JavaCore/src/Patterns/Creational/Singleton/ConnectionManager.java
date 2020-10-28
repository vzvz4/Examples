package Patterns.Creational.Singleton;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    public static class Connection {
        private String address;
        private String socket;

        private Connection(String address, String socket) {
            this.address = address;
            this.socket = socket;
        }
        public void connect() {
            System.out.println("Connected to " + address + ": Socket - " +socket);
        }
    }

    private static final List<Connection> connections;
    private static int counter;
    static {
        connections = new ArrayList<>();
        connections.add(new Connection("172.20.10.1","server.Socket"));
        connections.add(new Connection("172.20.10.6","host.Socket"));
    }
    private static final int LIMIT = connections.size();

    public static Connection getConnection() {
        if(counter < LIMIT) {
            return connections.get(counter++);
        } else return null;
    }

    public static List<Connection> getConnections() {
        return connections;
    }
}