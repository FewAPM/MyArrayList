package module_nine;

import java.util.Stack;

public class MyStack {
    int size;
    Node head;
    Node tail;

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("fourth");
        System.out.println("stack.peek() stack= " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.peek() stack= " + stack.peek());


    }

    public Node peek() {

        return get(size - 1);
    }

    public Node pop() {
        Node pop = get(size - 1);
        remove(size - 1);
        return pop;
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node beforeIndex = get(index).getPrev();
            Node atIndex = get(index);
            beforeIndex.next = atIndex.next;
        }
        size--;
    }

    public Node get(int index) {
        Node search = head;

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = 0; i < index; i++) {
                search = search.next;

            }
        }
        return search;
    }


    public void push(String value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    static class Node {
        String value;
        Node next;
        Node prev;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }

        public Node getNext() {

            return next;
        }

        public Node getPrev() {

            return prev;
        }
    }
}
