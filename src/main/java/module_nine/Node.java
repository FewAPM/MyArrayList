package module_nine;

public class Node<T, I> {

    static int size = 0;
    private T value;
    private Node<T, I> next;
    private Node<T, I> prev;


    public T getValue() {
        return value;
    }


    public void setValue(T value) {
        this.value = value;
    }

    public Node<T, I> getNext() {

        return next;
    }

    public void setNext(Node<T, I> next) {

        this.next = next;
    }

    public Node<T, I> getPrev() {
        return prev;
    }

    public void setPrev(Node<T, I> prev) {
        this.prev = prev;
    }
}
