package Test;

public interface Sum {
    default int sum(int a, int b) {
        return a+b;
    }
}
