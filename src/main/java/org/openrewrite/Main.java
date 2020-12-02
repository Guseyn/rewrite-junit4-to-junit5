package org.openrewrite;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.openrewrite.java.testing.junit5.AssertToAssertions;
import org.openrewrite.java.testing.junit5.CategoryToTag;
import org.openrewrite.visitors.TemporaryFolderToTempDir;
import org.openrewrite.visitors.UpdateTestAnnotation;
import org.openrewrite.visitors.ExpectedExceptionToAssertThrows;
import org.openrewrite.visitors.ReplaceAnnotationOnMethods;

public class Main {
    private static final String CODE_FOLDER = "src/main/java/org/openrewrite/testdata";
    public static void main(String... args) throws IOException {
        List<RefactorVisitor<?>> visitors = Arrays.asList(
            new AssertToAssertions(),
            new CategoryToTag(),
            new ExpectedExceptionToAssertThrows(),
            new UpdateTestAnnotation(),
            new TemporaryFolderToTempDir(),
            new ReplaceAnnotationOnMethods(
                "org.junit.Test",
                "org.junit.jupiter.api.Test"
            ),
            new ReplaceAnnotationOnMethods(
                "org.junit.Before",
                "org.junit.jupiter.api.BeforeEach"
            ),
            new ReplaceAnnotationOnMethods(
                "org.junit.After",
                "org.junit.jupiter.api.AfterEach"
            ),
            new ReplaceAnnotationOnMethods(
                "org.junit.BeforeClass",
                "org.junit.jupiter.api.BeforeAll"
            ),
            new ReplaceAnnotationOnMethods(
                "org.junit.AfterClass",
                "org.junit.jupiter.api.AfterAll"
            ),
            new ReplaceAnnotationOnMethods(
                "org.junit.Ignore",
                "org.junit.jupiter.api.Disabled"
            )
        );
        RefactorProcessor.run(visitors, CODE_FOLDER);
    }
}
