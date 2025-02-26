package org.example;

/**
 * Implementación de pila utilizando una lista
 */
public class ListStack<T> extends AbstractStack<T> {
    private final IList<T> list;

    /**
     * Constructor
     * @param list La lista a utilizar para implementar la pila
     */
    public ListStack(IList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        validateNotNull(item);
        list.addFirst(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}