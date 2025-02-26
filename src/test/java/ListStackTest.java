

import org.example.DoublyLinkedList;
import org.example.ListStack;
import org.example.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

public class ListStackTest {
    @Nested
    @DisplayName("Pruebas con SinglyLinkedList")
    class WithSinglyLinkedList {
        private ListStack<String> stack;

        @BeforeEach
        void setUp() {
            stack = new ListStack<>(new SinglyLinkedList<>());
        }

        @Test
        @DisplayName("Prueba de push y pop")
        void testPushAndPop() {
            stack.push("A");
            stack.push("B");
            stack.push("C");

            assertEquals(3, stack.size());
            assertEquals("C", stack.pop());
            assertEquals("B", stack.pop());
            assertEquals("A", stack.pop());
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("Prueba de peek")
        void testPeek() {
            stack.push("A");
            stack.push("B");

            assertEquals("B", stack.peek());
            assertEquals(2, stack.size());
        }

        @Test
        @DisplayName("Prueba de excepciones")
        void testExceptions() {
            assertThrows(IllegalArgumentException.class, () -> stack.push(null));
            assertThrows(IllegalStateException.class, () -> stack.pop());
            assertThrows(IllegalStateException.class, () -> stack.peek());
        }
    }

    @Nested
    @DisplayName("Pruebas con DoublyLinkedList")
    class WithDoublyLinkedList {
        private ListStack<String> stack;

        @BeforeEach
        void setUp() {
            stack = new ListStack<>(new DoublyLinkedList<>());
        }

        @Test
        @DisplayName("Prueba de push y pop")
        void testPushAndPop() {
            stack.push("A");
            stack.push("B");
            stack.push("C");

            assertEquals(3, stack.size());
            assertEquals("C", stack.pop());
            assertEquals("B", stack.pop());
            assertEquals("A", stack.pop());
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("Prueba de peek")
        void testPeek() {
            stack.push("A");
            stack.push("B");

            assertEquals("B", stack.peek());
            assertEquals(2, stack.size());
        }

        @Test
        @DisplayName("Prueba de isEmpty y size")
        void testIsEmptyAndSize() {
            assertTrue(stack.isEmpty());
            assertEquals(0, stack.size());

            stack.push("A");
            assertFalse(stack.isEmpty());
            assertEquals(1, stack.size());

            stack.push("B");
            assertEquals(2, stack.size());

            stack.pop();
            assertEquals(1, stack.size());

            stack.pop();
            assertTrue(stack.isEmpty());
            assertEquals(0, stack.size());
        }
    }
}