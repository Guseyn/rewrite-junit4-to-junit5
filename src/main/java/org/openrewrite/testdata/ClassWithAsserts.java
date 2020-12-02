package org.openrewrite.testdata;

import org.junit.jupiter.api.Assertions;

public class ClassWithAsserts {
    void foo() {
        Assertions.assertEquals(1, 1);
        Assertions.assertArrayEquals(new int[]{}, new int[]{});
        Assertions.assertNotEquals(1, 2);
        Assertions.assertFalse(false);
        Assertions.assertTrue(true);
        Assertions.assertEquals("foo", "foo");
        Assertions.assertNull(null);
        Assertions.fail();
    }
}
