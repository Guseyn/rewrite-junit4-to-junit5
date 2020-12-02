package org.openrewrite.testdata;

import org.junit.Assert;

public class ClassWithAsserts {
    void foo() {
        Assert.assertEquals(1, 1);
        Assert.assertArrayEquals(new int[]{}, new int[]{});
        Assert.assertNotEquals(1, 2);
        Assert.assertFalse(false);
        Assert.assertTrue(true);
        Assert.assertEquals("foo", "foo");
        Assert.assertNull(null);
        Assert.fail();
    }
}
