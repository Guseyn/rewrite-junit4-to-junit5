package org.openrewrite.testdata;

import org.junit.Assert;

public class ClassWithAssertsAndMessages {
    void foo() {
        Assert.assertEquals("One is one", 1, 1);
        Assert.assertArrayEquals("Empty is empty", new int[]{}, new int[]{});
        Assert.assertNotEquals("one is not two", 1, 2);
        Assert.assertFalse("false is false", false);
        Assert.assertTrue("true is true", true);
        Assert.assertEquals("foo is foo", "foo", "foo");
        Assert.assertNull("null is null", null);
        Assert.fail("fail");
    }
}
