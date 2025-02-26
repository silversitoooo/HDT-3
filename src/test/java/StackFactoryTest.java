

import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class StackFactoryTest {
    @Test
    @DisplayName("Prueba de creación de pilas")
    void testCreateStack() {
        assertInstanceOf(ArrayListStack.class, StackFactory.createStack("ArrayList"));
        assertInstanceOf(VectorStack.class, StackFactory.createStack("Vector"));
        assertThrows(IllegalArgumentException.class, () -> StackFactory.createStack("Unknown"));
    }

    @Test
    @DisplayName("Prueba de creación de listas")
    void testCreateList() {
        assertInstanceOf(SinglyLinkedList.class, StackFactory.createList("SinglyLinkedList"));
        assertInstanceOf(DoublyLinkedList.class, StackFactory.createList("DoublyLinkedList"));
        assertThrows(IllegalArgumentException.class, () -> StackFactory.createList("Unknown"));
    }
}