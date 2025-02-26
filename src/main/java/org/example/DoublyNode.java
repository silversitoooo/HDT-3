package org.example;

/**
 * Nodo para lista doblemente enlazada
 */
public class DoublyNode<T> {
    public T data;
    public DoublyNode<T> next;
    public DoublyNode<T> prev;

    /**
     * Constructor
     * @param data Los datos del nodo
     */
    public DoublyNode(T data) {
        this.data = data;
    }
}