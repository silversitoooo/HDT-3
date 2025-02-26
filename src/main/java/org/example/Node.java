package org.example;

/**
 * Nodo para lista simplemente enlazada
 */
public class Node<T> {
    private final T data;
    private Node<T> next;

    /**
     * Constructor
     * @param data Los datos del nodo
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Obtiene los datos del nodo
     * @return Los datos almacenados en el nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Obtiene el siguiente nodo
     * @return El siguiente nodo en la lista, o null si no hay siguiente
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo
     * @param next El nodo que será el siguiente en la lista
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
