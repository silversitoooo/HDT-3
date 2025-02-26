

import org.example.AbstractList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractListTest {

    // Clase de implementación concreta para probar AbstractList
    private static class TestList<T> extends AbstractList<T> {
        public void testValidateNotNull(T item) {
            validateNotNull(item);
        }

        @Override
        public void addFirst(T item) {
            validateNotNull(item);
        }

        @Override
        public T removeFirst() {
            return null;
        }

        @Override
        public T getFirst() {
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
        TestList<String> list = new TestList<>();

        // No debería lanzar excepción
        list.testValidateNotNull("test");

        // Debería lanzar IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> list.testValidateNotNull(null));
    }
}