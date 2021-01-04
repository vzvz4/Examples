package Patterns.Structural.Adapter.ex1;

public interface Processor {

    default String name() {
        return this.getClass().getSimpleName();
    }

    Object process(Object input);
}
