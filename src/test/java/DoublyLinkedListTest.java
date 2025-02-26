import org.example.DoublyLinkedList;
import org.example.DoublyNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class DoublyLinkedListTest {
    private DoublyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    @DisplayName("Prueba de addFirst y removeFirst")
    void testAddFirstAndRemoveFirst() {
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("C", list.removeFirst());
        Assertions.assertEquals("B", list.removeFirst());
        Assertions.assertEquals("A", list.removeFirst());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Prueba de getFirst")
    void testGetFirst() {
        list.addFirst("A");
        list.addFirst("B");

        Assertions.assertEquals("B", list.getFirst());
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Prueba de tail")
    void testTail() {
        list.addFirst("A");
        Assertions.assertNotNull(list.getTail());
        Assertions.assertEquals("A", list.getTail().data);

        list.addFirst("B");
        Assertions.assertEquals("A", list.getTail().data);

        list.removeFirst();
        Assertions.assertEquals("A", list.getTail().data);

        list.removeFirst();
        Assertions.assertNull(list.getTail());
    }

    @Test
    @DisplayName("Prueba de enlaces dobles")
    void testDoubleLinks() {
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");

        DoublyNode<String> tail = list.getTail();
        Assertions.assertNotNull(tail);
        Assertions.assertEquals("A", tail.data);
        Assertions.assertNull(tail.next);
        Assertions.assertNotNull(tail.prev);

        Assertions.assertEquals("B", tail.prev.data);
        Assertions.assertNotNull(tail.prev.prev);
        Assertions.assertEquals("C", tail.prev.prev.data);
        Assertions.assertNull(tail.prev.prev.prev);
    }

    @Test
    @DisplayName("Prueba de setTail")
    void testSetTail() {
        DoublyNode<String> newTail = new DoublyNode<>("X");
        list.setTail(newTail);
        Assertions.assertEquals(newTail, list.getTail());
    }

    @Test
    @DisplayName("Prueba de excepciones")
    void testExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        Assertions.assertThrows(IllegalStateException.class, () -> list.removeFirst());
        Assertions.assertThrows(IllegalStateException.class, () -> list.getFirst());
    }
}