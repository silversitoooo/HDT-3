

import org.example.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    @DisplayName("Prueba de creación de nodo simple")
    void testSimpleNodeCreation() {
        Node<String> node = new Node<>("test");
        assertEquals("test", node.getData());
        assertNull(node.getNext());
    }

    @Test
    @DisplayName("Prueba de enlace de nodos")
    void testLinkNodes() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.setNext(node2);

        assertEquals(1, node1.getData());
        assertEquals(2, node1.getNext().getData());
        assertNull(node1.getNext().getNext());
    }
}


