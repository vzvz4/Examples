package Algorithms.BackusNaurForm;

public class RecursiveDescentParser {
    // E -> T + E | T - E | T
    // T -> F * T | F / T | F
    // F -> E     | (E)

    // E -> T +- T +- T...
    // T -> F */ F */ F...

    // E(2 + 3 * (4 - 5) + 6 - 7) ->
    // T(2) + E(3 * (4 - 5) + 6 - 7) ->
    // T(2) + T(3 * (4 - 5)) + T(6) - T(7) ->
    // T(2) + F(3) * T(4 - 5) + T(6) - T(7)

    private String[] tokens;
    private int pos;

    public RecursiveDescentParser(String[] tokens) {
        this.tokens = tokens;
    }

    public static void main(String[] args) {
        String exp = "3 + sin( 3 + 4 * ( 5 + 10 ) ) + sin( 10 * 3 + sin( 6 + 7 ) )";
        RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(exp.split("\\s"));
        System.out.println(recursiveDescentParser.expressive());
        System.out.println(3 + Math.sin(3 + 4 * (5 + 10)) + Math.sin(10 * 3 + Math.sin(6 + 7)));
    }

    // E
    private double expressive() {
        double first = term();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else pos++;
            double second = term();
            if (operator.equals("+")) {
                first += second;
            } else first -= second;
        }
        return first;
    }

    // T
    private double term() {
        double first = factor();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else pos++;
            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else first /= second;
        }
        return first;
    }

    // F
    private double factor() {
        String next = tokens[pos];
        double result;
        if (next.equals("sin(")) {
            pos++;
            result = Math.sin(expressive());
            pos++;
            return result;
        } else if (next.equals("(")) {
            pos++;
            result = expressive();
            String closingBracket = tokens[pos];
            if (closingBracket.equals(")")) {
                pos++;
                return result;
            } else throw new IllegalStateException();
        }
        pos++;
        return Double.parseDouble(next);
    }
}
