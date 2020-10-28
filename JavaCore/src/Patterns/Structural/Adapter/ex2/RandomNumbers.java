package Patterns.Structural.Adapter.ex2;

import java.util.Random;

public class RandomNumbers {
    private final Random random = new Random();

    public float next() {
        return random.nextFloat();
    }
}
