package Patterns.Behavioral.Strategy.Ex1;

import java.util.Arrays;

public class Splitter implements Processor {

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
