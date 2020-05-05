package InnerNestedLocalClassesEx.ExtendFromInner;

public class App {
    public static void main(String[] args) {
        N.InnerN i = new N().new InnerN(new K(),3);
        N.Sub s = new M().new Sub();
        int a = s.method();
    }
}
