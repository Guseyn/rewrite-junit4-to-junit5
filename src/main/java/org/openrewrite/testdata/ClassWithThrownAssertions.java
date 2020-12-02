package org.openrewrite.testdata;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ClassWithThrownAssertions {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public void throwsNothing() {
        // no exception expected, none thrown: passes.
    }

    public void throwsExceptionWithSpecificType() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }
}
