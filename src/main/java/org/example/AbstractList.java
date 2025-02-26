package org.example;

public abstract class AbstractList<T> implements IList<T> {
    protected void validateNotNull(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
    }

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract int size();
}