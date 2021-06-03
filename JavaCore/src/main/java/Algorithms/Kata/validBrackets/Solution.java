package Algorithms.Kata.validBrackets;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Solution {

    public static boolean validParentheses1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            else if (str.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static boolean validParentheses2(String parens) {
        try {
            Pattern.compile(parens.replaceAll("[^()]", ""));
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    private static class MySolution {
        public static boolean validParentheses(String parens) {
            Stack<String> tokens = Arrays.stream(parens.split(""))
                    .collect(Collectors.toCollection(Stack::new));
            return check(tokens);
        }

        private static boolean check(Stack<String> tokens) {
            Stack<Integer> openBrackets = new Stack<>();
            int lastInd = 0;
            for (int i = lastInd; i < tokens.size(); i++) {
                String current = tokens.get(i);
                if (current.equals("("))
                    openBrackets.push(i);
                else if (current.equals(")") && openBrackets.isEmpty())
                    return false;
                else if (current.equals(")")) {
                    int lastOpenBracket = openBrackets.pop();
                    tokens.remove(i);
                    tokens.remove(lastOpenBracket);
                    i = openBrackets.isEmpty() ? -1 : openBrackets.peek();
                }
            }
            return openBrackets.isEmpty() && !tokens.contains(")");
        }
    }
}
