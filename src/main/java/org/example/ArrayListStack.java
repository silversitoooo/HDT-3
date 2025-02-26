package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de pila utilizando ArrayList
 */
public class ArrayListStack<T> implements IStack<T> {
    private final List<T> items = new ArrayList<>();

    @Override
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }
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