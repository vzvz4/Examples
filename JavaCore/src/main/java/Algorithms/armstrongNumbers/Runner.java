package Algorithms.armstrongNumbers;

import java.util.Set;

public class Runner {

    private Armstrong armstrong = new Armstrong();

    public long[] exec(int level) {
        Set<String> aNumbers = armstrong.level(level);
        return aNumbers.stream().mapToLong(Long::parseLong).sorted().toArray();
    }

}
