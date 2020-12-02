package org.openrewrite.testdata;

import org.junit.Test;

public class ClassWithTestAnnotation {
    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        throw new IllegalArgumentException("boom");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test3() {
        int arr = new int[]{}[0];
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        String foo = "foo";
        throw new IllegalArgumentException("boom");
    }

    @Test
    public void test7() { }

    @Test(timeout = 500)
    public void test8() { }

    @Test(expected = IllegalArgumentException.class, timeout = 500)
    public void test9() {
        throw new IllegalArgumentException("boom");
    }
}
