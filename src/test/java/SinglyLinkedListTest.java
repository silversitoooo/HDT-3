

import org.example.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("Prueba de addFirst y removeFirst")
    void testAddFirstAndRemoveFirst() {
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");

        assertEquals(3, list.size());
        assertEquals("C", list.removeFirst());
        assertEquals("B", list.removeFirst());
        assertEquals("A", list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Prueba de getFirst")
    void testGetFirst() {
        list.addFirst("A");
        list.addFirst("B");

        assertEquals("B", list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Prueba de isEmpty")
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst("A");
        assertFalse(list.isEmpty());
        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Prueba de size")
    void testSize() {
        assertEquals(0, list.size());
        list.addFirst("A");
        assertEquals(1, list.size());
        list.addFirst("B");
        assertEquals(2, list.size());
        list.removeFirst();
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Prueba de excepciones")
    void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        assertThrows(IllegalStateException.class, () -> list.removeFirst());
        assertThrows(IllegalStateException.class, () -> list.getFirst());
    }
}
