package core;

import core.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ClientManager {

    private final ConnectionManager connectionManager;
    private Connection connection;
    private DBConnection dbConnection;
    private Scanner sc;

    public ClientManager() {
        this.connectionManager = new ConnectionManager();
    }

    private void showAvailableAliasList() {
        System.out.print("Available aliases: ");
        connectionManager.getConnectionList().forEach((key, value) -> System.out.print(key + " | "));
        System.out.println("");
    }

    private void showConnectionConfig() {
        System.out.println("Connection configurations ======== ");
        System.out.println(dbConnection.getCfg().showParams());
        System.out.println("====================");
    }

    private enum Commands {
        EXIT("exit", ""),
        ALIAS("alias", " - shows available aliases"),
        CONFIG("config", " - shows current connection configuration"),
        HELP("help", ""),
        CONNECT("connect", " - usage: connect 'alias_name'"),
        BACK("back", " - back from CRUD menu");
        private final String commandText;
        private final String commandDescription;

        Commands(String commandText, String commandDescription) {
            this.commandDescription = commandDescription;
            this.commandText = commandText;
        }
    }

    private class CRUDOperator {

        private void initSession() {
            System.out.println("DB Connected, alias: " + dbConnection.getCfg().getAlias());
            showConnectionConfig();
            sc.reset();
            while (true) {
                System.out.print("CRUD> ");
                String query = sc.nextLine();
                if (query.equals(Commands.BACK.commandText)) {
                    System.out.println("Connection closed");
                    sc.reset();
                    break;
                } else if (query.toLowerCase().startsWith("select"))
                    select(query);
                else if (query.toLowerCase().startsWith("insert"))
                    insert(query);
                else if (query.toLowerCase().startsWith("delete"))
                    delete(query);
                else if (query.toLowerCase().startsWith("create"))
                    create(query);
                else if (query.toLowerCase().equals(Commands.CONFIG.commandText))
                    showConnectionConfig();
                else System.out.println("Unknown command");
            }
        }

        private void create(String query) {
            try (Statement stmt = connection.createStatement()) {
                int u = stmt.executeUpdate(query);
                System.out.println("Success created, rows changed: " + u);
            } catch (SQLException s) {
                System.out.println("ERROR while creating");
            }
        }

        private void select(String query) {
            drawTable(query);
        }

        private void insert(String query) {
            try (Statement stmt = connection.createStatement()) {
                int u = stmt.executeUpdate(query);
                System.out.println("Success inserted, rows changed: " + u);
            } catch (SQLException s) {
                System.out.println("ERROR while inserting");
            }
        }

        private void delete(String query) {
            try (Statement stmt = connection.createStatement()) {
                int u = stmt.executeUpdate(query);
                System.out.println("Success deleted, rows changed: " + u);
            } catch (SQLException s) {
                System.out.println("ERROR while deleting");
            }
        }
    }

    private void printHelp() {
        Commands[] commands = Commands.values();
        System.out.println("Available commands: ");
        Arrays.stream(commands).forEach(x -> System.out.println(x.commandText + "  " + x.commandDescription));
    }

    public void commandListener() {
        sc = new Scanner(System.in);
        while (true) {
            System.out.print("cldbc> ");
            String command = sc.nextLine();
            if (command.equals(Commands.EXIT.commandText)) {
                System.out.println("Exit");
                break;
            } else if (command.equals(Commands.CONFIG.commandText)) {
                System.out.println("No connection detected");
                System.out.println("To init connection use: connect 'alias_name'");
                showAvailableAliasList();
            } else if (command.equals(Commands.ALIAS.commandText))
                showAvailableAliasList();
            else if (command.equals(Commands.HELP.commandText) || command.equals("?")) {
                printHelp();
            } else if (command.startsWith(Commands.CONNECT.commandText)) {
                sc.reset();
                String[] commandSet = command.split(" ");
                String alias;
                if (commandSet.length == 2)
                    alias = commandSet[1];
                else if (commandSet.length == 1) {
                    System.out.println("Select available aliases");
                    showAvailableAliasList();
                    alias = sc.nextLine();
                } else {
                    System.out.println("ERROR Wrong alias");
                    continue;
                }
                dbConnection = connectionManager.getConnectionList().get(alias);
                try {
                    connection = dbConnection.createConn();
                    new CRUDOperator().initSession();
                    connection.close();
                } catch (SQLException | ClassNotFoundException s) {
                    System.out.println("ERROR with connection, wrong alias?");
                }
            } else {
                System.out.println("Unknown command");
                System.out.println("If you want to init connection use - connect 'alias_name'");
                printHelp();
            }
        }
        closeResources();
    }

    private void closeResources() {
        sc.close();
        try {
            connection.close();
        } catch (SQLException s) {
            System.out.println("ERROR DB connection has not closed");
        }
    }

    public void drawTable(String query) {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            int columns = rs.getMetaData().getColumnCount();
            ArrayList<String>[] res = new ArrayList[columns];
            for (int i = 0; i < res.length; i++) {
                res[i] = new ArrayList<>();
            }

            int colInd;
            boolean flag = true;

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    if (flag)
                        res[i - 1].add(" " + rs.getMetaData().getColumnLabel(i));
                    res[i - 1].add(" " + rs.getString(i));
                }
                flag = false;
            }

            for (ArrayList<String> re : res) {
                OptionalInt opt = re.stream().filter(Objects::nonNull).mapToInt(String::length).max();
                int length = opt.isPresent() ? opt.getAsInt() : "null".length();
                for (int i = 0; i < re.size(); i++) {
                    StringBuilder space = new StringBuilder("  ");
                    if (re.get(i) != null) {
                        for (int k = 0; k < length - re.get(i).length(); k++) {
                            space.append(" ");
                        }
                        re.set(i, re.get(i) + space);
                    } else {
                        for (int j = 0; j < length - "null".length(); j++)
                            space.append(" ");
                        re.set(i, "    " + space);
                    }
                }
            }

            colInd = 0;
            boolean canWrite;
            String[] lines = new String[columns];

            for (ArrayList<String> strings : res) {
                StringBuilder line = new StringBuilder("+");
                for (int j = 0; j < strings.get(0).length(); j++)
                    line.append("-");
                lines[colInd] = line.toString();
                if (colInd == lines.length - 1)
                    lines[colInd] = lines[colInd].concat("+");
                colInd++;
            }

            colInd = 0;
            int row = 0;

            for (int i = 0; i < res[colInd].size(); i++) {
                if (colInd++ == columns - 1)
                    colInd = 0;
                canWrite = row == 1 || row == 0;
                row++;
                if (canWrite) {
                    Arrays.stream(lines).forEach(System.out::print);
                    System.out.println("");
                }
                for (ArrayList<String> re : res)
                    System.out.print("|" + re.get(i));

                System.out.println("|");
            }
            Arrays.stream(lines).forEach(System.out::print);
            System.out.println("");
            System.out.println("DB rows: " + (row - 1));
            System.out.println("DB columns: " + res.length);
        } catch (SQLException s) {
            System.out.println("ERROR while selecting");
        }
    }

}
