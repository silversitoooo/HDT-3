

import org.example.DoublyNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyNodeTest {
    @Test
    @DisplayName("Prueba de creación de nodo doble")
    void testDoublyNodeCreation() {
        DoublyNode<String> node = new DoublyNode<>("test");
        assertEquals("test", node.data);
        assertNull(node.next);
        assertNull(node.prev);
    }

    @Test
    @DisplayName("Prueba de enlaces dobles")
    void testDoubleLinks() {
        DoublyNode<Integer> node1 = new DoublyNode<>(1);
        DoublyNode<Integer> node2 = new DoublyNode<>(2);
        DoublyNode<Integer> node3 = new DoublyNode<>(3);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        assertEquals(1, node1.data);
        assertEquals(2, node1.next.data);
        assertEquals(3, node1.next.next.data);
        assertNull(node1.prev);

        assertEquals(1, node2.prev.data);
        assertEquals(3, node2.next.data);

        assertEquals(2, node3.prev.data);
        assertNull(node3.next);
    }
}