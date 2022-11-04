package module_nine;

public class MyLinkedList {
    int size;
    Node head;
    Node tail;

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
        System.out.println("list.size = " + list.size);
        list.remove(3);
        System.out.println("list.size = " + list.size);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("list.get(3) = " + list.get(3));
        list.clear();
        System.out.println("list.size = " + list.size);


    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index is " + index + " size is " + size);
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
            throw new IndexOutOfBoundsException("Index is " + index + " size is " + size);
        } else {
            for (int i = 0; i < index; i++) {
                search = search.next;

            }
        }
        return search;
    }


    public void add(String value) {
        Node newNode = new Node(value);
        System.out.println(tail);
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

