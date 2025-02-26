package org.example;

/**
 * Implementación de lista simplemente enlazada
 */
public class SinglyLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private int size;

    @Override
    public void addFirst(T item) {
        validateNotNull(item);
        Node<T> newNode = new Node<>(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return head.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}