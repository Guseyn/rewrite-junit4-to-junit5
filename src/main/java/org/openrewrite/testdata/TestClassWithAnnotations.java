package org.openrewrite.testdata;
import org.junit.jupiter.api.*;

public class TestClassWithAnnotations {
    @Test
    public void testSomething() {
        org.junit.jupiter.api.Assertions.assertTrue(true);
    }

    @BeforeEach
    public void before() { }

    @AfterEach
    public void after() { }

    @BeforeAll
    public void beforeClass() { }

    @AfterAll
    public void afterClass() { }

    @Disabled
    public void ignore() { }
}
