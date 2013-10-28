package preExam;

public class Node<T> {

    private T element;
    private boolean removeable;
    private Node next;

    public Node(T t) {
        this.element = t;
        this.removeable = false;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public boolean isRemoveable() {
        return removeable;
    }

    public void setRemoveable(boolean removeable) {
        this.removeable = removeable;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
