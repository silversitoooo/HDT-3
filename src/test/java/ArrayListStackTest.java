

import org.example.ArrayListStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListStackTest {
    private final ArrayListStack<String> stack = new ArrayListStack<>();

    @Test
    public void testPushAndPop() {
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push("A");
        assertEquals("A", stack.peek());
        stack.push("B");
        assertEquals("B", stack.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push("A");
        assertEquals(1, stack.size());
        stack.push("B");
        assertEquals(2, stack.size());
    }

    @Test
    public void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            stack.push(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        });
        assertThrows(IllegalStateException.class, () -> {
            stack.peek();
        });
    }
}