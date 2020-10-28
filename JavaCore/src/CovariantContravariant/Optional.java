package CovariantContravariant;

public class Optional<A> {
  //...ковариантный тип Optional

    public static <B, A extends B> Optional<B> widen(Optional<A> opt) {
        return (Optional) opt;
    }
}