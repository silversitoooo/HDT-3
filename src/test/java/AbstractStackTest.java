

import org.example.AbstractStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractStackTest {

    // Clase de implementación concreta para probar AbstractStack
    private static class TestStack<T> extends AbstractStack<T> {
        @Override
        public void push(T item) {
            validateNotNull(item);
        }

        @Override
        public T pop() {
            return null;
        }

        @Override
        public T peek() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    @Test
    @DisplayName("Prueba de validación de no nulos")
    void testValidateNotNull() {
        TestStack<String> stack = new TestStack<>();

        // No debería lanzar excepción
        stack.push("test");

        // Debería lanzar IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }
}