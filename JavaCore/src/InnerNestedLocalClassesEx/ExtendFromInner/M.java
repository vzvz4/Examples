package InnerNestedLocalClassesEx.ExtendFromInner;

public class M extends N {

    public class Sub extends N.Sub {
        @Override
        public int method() {
            //чтобы использовать эту переменную в локальном классе она должна быть
            //effectively final (как в этом примере) или final
            int x = 1;
            class Jazz {
                public int increment() {
                    int b = x + 3;
                    System.out.println(b + " Integer from local Jazz class");
                    return b;
                }
            }
            return new Jazz().increment();
        }
    }


}
