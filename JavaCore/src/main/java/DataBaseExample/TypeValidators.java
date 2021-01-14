package DataBaseExample;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TypeValidators {

    public static final TypeValidator defaultValidator = (node, data) -> {
        if (data.length() > node.getType().getLength()) {
            throw new IllegalArgumentException(
                    String.format("check length: %s, required: %s", data, node.getType().getLength()));
        } else
            return data;
    };

    public static final TypeValidator doubleValidator = (node, data) -> {
        try {
            defaultValidator.validate(node, data);
            double value = Double.parseDouble(data);
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
            return decimalFormat.format(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + ", wrong data: " + node);
        }
    };

    public static final TypeValidator integerValidator = (node, data) -> {
        try {
            defaultValidator.validate(node, data);
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
}
