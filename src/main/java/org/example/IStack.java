package org.example;

/**
 * Interfaz para todas las implementaciones de pilas
 */
public interface IStack<T> {
    /**
     * Añade un elemento a la pila
     * @param item El elemento a añadir
     */
    void push(T item);

    /**
     * Elimina y devuelve el elemento superior de la pila
     * @return El elemento superior
     */
    T pop();

    /**
     * Obtiene el elemento superior de la pila sin eliminarlo
     * @return El elemento superior
     */
    T peek();

    /**
     * Verifica si la pila está vacía
     * @return true si está vacía, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Obtiene el tamaño de la pila
     * @return El número de elementos en la pila
     */
    int size();
}