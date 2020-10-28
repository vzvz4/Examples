package CollectionsExample;

import java.util.Stack;

public class StackE {

    public static void main(String[] args) {
        //Stack - первый зашел последний вышел (LIFO)
        //pop() - вытаскивает и удаляет последний элемент
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.pop();
        int a = 0;
        while (stack.size() != 10) {
            stack.push(a++);
        }
        System.out.println("Стак заполнен " + stack);
        while (!stack.isEmpty()) {
            stack.pop();
            System.out.println(stack);
        }
    }

}
