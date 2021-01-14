package DataBaseExample;

public enum Type {

    STRING(30, TypeValidators.defaultValidator),
    INT(8, TypeValidators.integerValidator),
    DOUBLE(8, TypeValidators.doubleValidator),
    TINY_INT(4, TypeValidators.integerValidator),
    ID(16, TypeValidators.integerValidator);

    private final int length;
    private final TypeValidator validator;

    Type(int length, TypeValidator validator) {
        this.length = length;
        this.validator = validator;
    }

    public int getLength() {
        return length;
    }

    public TypeValidator getValidator() {
        return validator;
    }

}
