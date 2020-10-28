package StreamAPI.MethodReference;

public class TransformUtil <T> {
    //Usage:
    //customClassInstance::nonStaticMethod;
    //CustomClass::nonStaticMethod;
    //CustomClass::staticMethod;
    //CustomClass::new*;

    T transformField(T t, Transformable<T> func) {
        return func.transform(t);
    }

    @FunctionalInterface
    public interface Transformable<H> {
        H transform(H t);
    }

    // !!!Static
    static String execute(String s) {
        return s.toUpperCase() + "@mail.ru";
    }

    public static void main(String[] args) {
        Double d = -0.09;

        TransformUtil<Double> transfer = new TransformUtil<>();
        transfer.transformField(d, Math::sin);

        TransformUtil<String> stringTransformUtil = new TransformUtil<>();
        stringTransformUtil.transformField("java", TransformUtil::execute); //out: JAVA@mail.ru


        stringTransformUtil.transformField("pojo", x -> x.toUpperCase());
        stringTransformUtil.transformField("glitch", String::toUpperCase);
        stringTransformUtil.transformField("prospect", String::new); //constructor
    }
}
