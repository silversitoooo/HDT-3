package org.example;

import java.util.Vector;

/**
 * Implementación de pila utilizando Vector
 */
public class VectorStack<T> extends AbstractStack<T> {
    private final Vector<T> items = new Vector<>();

    @Override
    public void push(T item) {
        validateNotNull(item);
        items.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return items.get(items.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }
}