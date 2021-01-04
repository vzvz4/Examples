package org.example;

import java.util.ArrayList;
import java.util.List;

public class Test {
    /**
     * Реализуйте метод dailyTemperatures
     */
    public static List<Integer> dailyTemperatures(List<Integer> t) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < t.size(); i++) {
            for (int j = i + 1; j < t.size(); j++) {
                if (t.get(j) > t.get(i)) {
                    result.add(j - i);
                    break;
                }
                if (j == t.size() - 1)
                    result.add(0);
            }
        }
        result.add(0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new ArrayList<Integer>(List.of(73, 74, 75, 71, 67, 68, 67, 68))));
    }

    public static void runCode() {
        //new int[]{73, 74, 75, 71, 69, 72, 76, 73}
        //[1, 1, 4, 2, 1, 1, 0, 0]
    }
}
