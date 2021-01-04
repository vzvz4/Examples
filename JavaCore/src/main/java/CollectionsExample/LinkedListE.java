package CollectionsExample;

import java.util.Arrays;

public class LinkedListE {
    public static void main(String[] args) {
        LinkedListE w = new LinkedListE();
        w.add(3);
        w.add(2);
        w.add(4);
        w.add(6);
        System.out.println(w);
    }

    private Node head;
    private int size;


    public void add(int val) {
        if (head == null) {
            this.head = new Node(val);
        }
        else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(val));
        }
        size++;
    }

    public int get(int index) {
        int currentInd = 0;
        Node temp = head;
        while (temp != null) {
            if (currentInd == index)
                return temp.getVal();
            else {
                temp = temp.getNext();
                currentInd++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        int currentInd = 0;
        Node temp = head;

        while (temp != null) {
            if (currentInd == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentInd++;
            }
        }
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;

        while (temp != null) {
            result[index++] = temp.getVal();
            temp = temp.getNext();

        }
        return Arrays.toString(result);
    }

    private static class Node {
        private int val;
        private Node next;

        public void getNextHash() {
            System.out.println(next.hashCode() + " значение: " + next.getVal());
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
