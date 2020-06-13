package Test.comp;

public interface Component {
    int execute();
    void add(Component... components);
}
