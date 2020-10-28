package InnerNestedLocalClassesEx.ExtendFromInner;

public class N {

    public class InnerN extends K.InnerK {
        public InnerN(K k, int a) {
            k.super(a);
            System.out.println(a + " InnerN");
        }
    }

    public class Sub {
        int method() {
            System.out.println("Ref");
            return 1;
        }
    }
}
