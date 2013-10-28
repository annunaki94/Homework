package preExam;

public abstract class LinkedList<T> {

    private int size;
    private int toErase;
    private Node<T> firstNode;

    abstract void checkIndex(int index);//Método que arroja una exepción en caso de indice inválido

    private T remove(int index) {
        checkIndex(index);
        Node<T> current = firstNode;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        current.setRemoveable(true);
        toErase++;
        size--;
        T element = current.getElement();
        if (toErase >= size) {
            lazyDeletion();
        }
        return element;
    }

    private void lazyDeletion() {
        while (firstNode.isRemoveable()) {
            firstNode = firstNode.next();
            toErase--;
        }
        Node<T> current = firstNode;
        while (toErase > 0) {
            Node<T> next = current.next();
            if (next.isRemoveable()) {
                current.setNext(next.next());
                toErase--;
            }
            current = next;
        }
    }
}
