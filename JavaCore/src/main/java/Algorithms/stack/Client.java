package Algorithms.stack;

public class Client {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStackImpl<>(10);
        stack.push("13");
        stack.push("123");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.push("0000");
        System.out.println(stack.pop());

        stack.push("asdwadw");


        stack.push("asdwadw");
        stack.push("asdwadw");
        stack.push("asdwadw");
        stack.push("asdwadw");

        System.out.println(stack);

    }
}
