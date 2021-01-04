package Patterns.Behavioral.Strategy;

public interface Processor<T, U> {

    default String name() {
        return this.getClass().getSimpleName();
    }

    U process(T input);
}
