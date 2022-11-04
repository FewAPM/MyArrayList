package module_nine;

public class MyQueue {

    int size;
    Node head;
    Node tail;

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");
        myQueue.add("Fourth");
        myQueue.add("Fifth");

        System.out.println("list.get(3) = " + myQueue.get(3));
        myQueue.remove(3);
        System.out.println("list.size = " + myQueue.size);
        myQueue.clear();
        System.out.println("myQueue.size = " + myQueue.size);

    }

    public Node peek() {
        return get(0);
    }

    public Node poll() {
        Node poll = get(0);
        remove(0);
        return poll;
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


    public void add(String value) {
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
