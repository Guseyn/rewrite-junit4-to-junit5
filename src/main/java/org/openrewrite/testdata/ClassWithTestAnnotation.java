package org.openrewrite.testdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassWithTestAnnotation {
    @Test
    public void test1() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("boom");
        });
    }

    @Test
    public void test3() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int arr = new int[]{}[0];
        });
    }

    @Test
    public void test5() {
        assertThrows(IllegalArgumentException.class, () -> {
            String foo = "foo";
            throw new IllegalArgumentException("boom");
        });
    }

    @Test
    public void test7() { }

    @Test@Timeout(500)
    public void test8() { }

    @Test@Timeout(500)
    public void test9() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("boom");
        });
    }
}
