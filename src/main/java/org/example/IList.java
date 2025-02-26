package org.example;

/**
 * Interfaz para todas las implementaciones de listas
 */
public interface IList<T> {
    /**
     * Añade un elemento al inicio de la lista
     * @param item El elemento a añadir
     */
    void addFirst(T item);

    /**
     * Elimina y devuelve el primer elemento de la lista
     * @return El primer elemento
     */
    T removeFirst();

    /**
     * Obtiene el primer elemento de la lista sin eliminarlo
     * @return El primer elemento
     */
    T getFirst();

    /**
     * Verifica si la lista está vacía
     * @return true si está vacía, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Obtiene el tamaño de la lista
     * @return El número de elementos en la lista
     */
    int size();
}