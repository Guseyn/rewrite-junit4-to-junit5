package org.openrewrite.testdata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ClassWithStaticAsserts {
    void foo() {
        assertEquals(1, 1);
        assertArrayEquals(new int[]{}, new int[]{});
        assertNotEquals(1, 2);
        assertFalse(false);
        assertTrue(true);
        assertEquals("foo", "foo");
        assertNull(null);
        fail();
    }
}
