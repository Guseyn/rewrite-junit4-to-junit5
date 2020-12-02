package org.openrewrite.testdata;

import org.junit.experimental.categories.Category;

public class ClassWithCategories {
    @Category({FastTests.class, SlowTests.class})
    public class B {

    }
}
