package Patterns.System.valueobject;

// Must be immutable
// Objects should be equals by meaning

// Объекты Значения – это небольшие простые объекты наподобие денежных значений или диапазонов дат,
// равенство которых основано не на равенстве идентификаторов [1], а на равенстве этих объектов по их значению.
public final class ValueObject {
    private final int a;
    private final String name;

    public ValueObject(int a, String name) {
        this.a = a;
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public String getName() {
        return name;
    }
}
