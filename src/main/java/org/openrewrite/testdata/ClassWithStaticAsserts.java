package org.openrewrite.testdata;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
