package org.example;

/**
 * Fábrica para crear diferentes tipos de pilas y listas
 */
public class StackFactory {
    /**
     * Crea una pila del tipo especificado
     * @param type El tipo de pila a crear
     * @return La pila creada
     */
    public static IStack<String> createStack(String type) {
        return switch (type) {
            case "ArrayList" -> new ArrayListStack<>();
            case "Vector" -> new VectorStack<>();
            // Ya no creamos la pila con lista aquí, lo haremos en el método principal
            default -> throw new IllegalArgumentException("Tipo de pila desconocido");
        };
    }

    /**
     * Crea una lista del tipo especificado
     * @param type El tipo de lista a crear
     * @return La lista creada
     */
    public static IList<String> createList(String type) {
        return switch (type) {
            case "SinglyLinkedList" -> new SinglyLinkedList<>();
            case "DoublyLinkedList" -> new DoublyLinkedList<>();
            default -> throw new IllegalArgumentException("Tipo de lista desconocido");
        };
    }
}