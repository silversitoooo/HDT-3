package org.example;

/**
 * Implementación de lista doblemente enlazada
 */
public class DoublyLinkedList<T> extends AbstractList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    @Override
    public void addFirst(T item) {
        validateNotNull(item);
        DoublyNode<T> newNode = new DoublyNode<>(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Obtiene el nodo final de la lista
     * @return El nodo final
     */
    public DoublyNode<T> getTail() {
        return tail;
    }

    /**
     * Establece el nodo final de la lista
     * @param tail El nodo a establecer como final
     */
    public void setTail(DoublyNode<T> tail) {
        this.tail = tail;
    }
}