package org.openrewrite.testdata;

import org.junit.jupiter.api.Assertions;

public class ClassWithAssertsAndMessages {
    void foo() {
        Assertions.assertEquals(1, 1, "One is one");
        Assertions.assertArrayEquals(new int[]{}, new int[]{}, "Empty is empty");
        Assertions.assertNotEquals(1, 2, "one is not two");
        Assertions.assertFalse(false, "false is false");
        Assertions.assertTrue(true, "true is true");
        Assertions.assertEquals("foo", "foo", "foo is foo");
        Assertions.assertNull(null, "null is null");
        Assertions.fail("fail");
    }
}
