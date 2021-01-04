package CovariantContravariant;

public interface Consumer<A> {
    //...контравариантный тип Consumer

    static <A, B extends A> Consumer<B> narrow(Consumer<A> con) {
        return (Consumer) con;
    }
}