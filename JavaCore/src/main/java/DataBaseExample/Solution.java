package DataBaseExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

/* 
Прайсы 2
*/

public class Solution {
    private static int colQuantity;
    private static Map<String, String[]> cache;

    private static ColumnNode[] columnNodes;
    private static Path path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (sc) {
            path = Paths.get(sc.nextLine());
            readTableInfo();
            cache = cache(path);
            switch (args[0]) {
                case "-u":
                    update(args);
                    break;
                case "-d":
                    delete(args);
                    break;
                case "-c":
                    create(args);
                    break;
                case "-r":
                    read(args);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read(String[] args) throws IllegalArgumentException {
        if (args.length == 1) {
            printAllTable();
        } else if (args.length == 2) {
            String id = integerVerifier.verify(columnNodes[0], args[1]);
            String[] entry = cache.get(id);
            if (entry != null) {
                String line = convertArgsToDataLine(entry);
                System.out.println(line);
            } else
                System.out.println("Not found");
        }
    }

    public static void delete(String[] args) throws IOException {
        String id = args[1];
        if (cache.containsKey(id)) {
            cache.remove(id);
            writeCache();
        }
    }

    public static void update(String[] args) throws IOException {
        try {
            String[] arguments = fillAndVerify(cutFirstArguments(args, 1));
            String[] entry = cache.get(arguments[0]);
            if (entry != null) {
                cache.put(arguments[0], arguments);
                writeCache();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void create(String[] args) throws IOException {
        try {
            String[] arguments = fillAndVerify(cutFirstArguments(args, 1));
            cache.put(arguments[0], arguments);
            sortTable();
            writeCache();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printAllTable() {
        for (String[] value : cache.values()) {
            System.out.println(convertArgsToDataLine(value));
        }
    }

    private static String[] cutFirstArguments(String[] args, int argumentsCount) {
        String[] argsValue = new String[colQuantity];
        if (args.length - 1 >= 0)
            System.arraycopy(args, argumentsCount, argsValue, 0, args.length - 1);
        return argsValue;
    }

    private static String[] fillAndVerify(String[] args) throws IllegalArgumentException {
        String[] data = new String[colQuantity];
        if (args.length < colQuantity) throw new IllegalArgumentException();
        else {
            for (int i = 0; i < args.length; i++) {
                data[i] = columnNodes[i].verify(args[i]);
            }
        }
        return data;
    }

    private static void sortTable() {
        cache = new TreeMap<>(cache);
    }

    private static Map<String, String[]> cache(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        Map<String, String[]> data = new LinkedHashMap<>();
        for (String line : lines) {
            String[] args = parseLine(line);
            data.put(args[0], args);
        }
        return data;
    }

    private static String[] parseLine(String line) {
        String[] tableArgs = new String[colQuantity];
        int first = 0;
        for (int i = 0; i < columnNodes.length; i++) {
            int last = columnNodes[i].type.length + first;
            tableArgs[i] = parseColumnData(line, first, last);
            first = last;
        }
        return tableArgs;
    }

    private static String parseColumnData(String line, int start, int end) {
        return line.substring(start, end).trim();
    }

    private static void writeCache() throws IOException {
        StringBuilder line = new StringBuilder();
        for (String[] args : cache.values()) {
            line.append(convertArgsToDataLine(args))
                    .append("\n");
        }
        Files.write(path, line.toString().getBytes());
    }

    private static String convertArgsToDataLine(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnNodes.length; i++) {
            String s = String.format("%-" + columnNodes[i].type.length + "." + columnNodes[i].type.length + "s", args[i]);
            sb.append(s);
        }
        return sb.toString();
    }

    private static void readTableInfo() {
        // Представим, что в программу передается мета информация о таблице -
        // количество колонок, размер каждой колонки, ее тип и тд
        colQuantity = 4;
        columnNodes = new ColumnNode[colQuantity];
        columnNodes[0] = new ColumnNode(Type.ID, "id");
        columnNodes[1] = new ColumnNode(Type.STRING, "prod_name");
        columnNodes[2] = new ColumnNode(Type.DOUBLE, "price");
        columnNodes[3] = new ColumnNode(Type.INT, "quantity");
    }

    private static final ColumnDataTypeVerifier<ColumnNode> defaultVerifier = (node, data) -> {
        if (data.length() > node.type.length) {
            throw new IllegalArgumentException(String.format("check length: %s, required: %s", data, node.type.length));
        } else
            return data;
    };

    private static final ColumnDataTypeVerifier<ColumnNode> doubleVerifier = (node, data) -> {
        try {
            defaultVerifier.verify(node, data);
            double value = Double.parseDouble(data);
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
            return decimalFormat.format(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + ", wrong data: " + node);
        }
    };

    private static final ColumnDataTypeVerifier<ColumnNode> integerVerifier = (node, data) -> {
        try {
            defaultVerifier.verify(node, data);
            String current = data;
            if (data.matches("\\d+\\.\\d+")) {
                current = current.substring(0, current.indexOf('.'));
            }
            int value = Integer.parseInt(current);
            return Integer.toString(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage() + ", wrong data: " + node);
        }
    };

    private enum Type {
        STRING(30, defaultVerifier),
        DOUBLE(8, doubleVerifier),
        INT(4, integerVerifier),
        ID(8, integerVerifier);

        int length;
        ColumnDataTypeVerifier<ColumnNode> verifier;

        Type(int i, ColumnDataTypeVerifier<ColumnNode> defaultVerifier) {
            length = i;
            verifier = defaultVerifier;
        }
    }

    private interface ColumnDataTypeVerifier<T> {
        String verify(T node, String data) throws IllegalArgumentException;
    }

    private static class ColumnNode {
        Type type;
        String name;

        public ColumnNode(Type type, String name) {
            this.type = type;
            this.name = name;
        }

        public String verify(String data) throws IllegalArgumentException {
            if (type.verifier == null) {
                type.verifier = Solution.defaultVerifier;
            }
            return type.verifier.verify(this, data);
        }

        public void setVerifier(ColumnDataTypeVerifier<ColumnNode> verifier) {
            this.type.verifier = verifier;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return "ColumnNode{" +
                    "type=" + type +
                    '}';
        }
    }
}
