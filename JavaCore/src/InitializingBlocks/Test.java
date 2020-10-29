package InitializingBlocks;

public class Test {
    static {
        System.out.println("Static init block");
    }
    {
        System.out.println("object init block");
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
