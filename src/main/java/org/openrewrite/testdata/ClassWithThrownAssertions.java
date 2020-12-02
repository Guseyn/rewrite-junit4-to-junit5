package org.openrewrite.testdata;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassWithThrownAssertions {

    public void throwsNothing() {
        // no exception expected, none thrown: passes.
    }

    public void throwsExceptionWithSpecificType() {
        assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException();
        });
    }
}
