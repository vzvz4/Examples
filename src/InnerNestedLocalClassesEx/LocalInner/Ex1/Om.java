package InnerNestedLocalClassesEx.LocalInner.Ex1;

public class Om {

    public OpenI mtd() {
        class In implements OpenI {

            @Override
            public String hey(String b) {
                return "JABBA " + b ;
            }
        }
        return new In();
    }
    
    public static void main(String[] args) {
        System.out.println(new Om().mtd().hey("BOOOBS"));
    }

}
