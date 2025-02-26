package org.example;

/**
 * Clase abstracta que implementa la interfaz IStack
 * Proporciona funcionalidad común para todas las pilas
 */
public abstract class AbstractStack<T> implements IStack<T> {
    /**
     * Valida que el elemento no sea nulo
     * @param item El elemento a validar
     */
    protected void validateNotNull(T item) {
        if (item == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }
    }

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract int size();
}