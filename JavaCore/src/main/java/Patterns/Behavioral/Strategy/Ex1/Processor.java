package Patterns.Behavioral.Strategy.Ex1;

public interface Processor<T, U> {

    default String name() {
        return this.getClass().getSimpleName();
    }

    U process(T input);
}
