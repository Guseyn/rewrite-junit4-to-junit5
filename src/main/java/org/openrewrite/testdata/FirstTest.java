package org.openrewrite.testdata;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class FirstTest {
    @Test
    public void testSomething() {
        org.junit.Assert.assertTrue(true);
    }

    @Before
    public void before() { }

    @After
    public void after() { }

    @BeforeClass
    public void beforeClass() { }

    @AfterClass
    public void afterClass() { }

    @Ignore
    public void ignore() { }
}
