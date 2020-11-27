package org.openrewrite;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.visitors.ReplaceAnnotationOnMethods;

public class Main {
    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new ArrayList<>(){{
            add(new ReplaceAnnotationOnMethods(
                "org.junit.Test", "org.junit.jupiter.api.Test"
            ));
            add(new ReplaceAnnotationOnMethods(
                "org.junit.Before", "org.junit.jupiter.api.BeforeEach"
            ));
            add(new ReplaceAnnotationOnMethods(
                "org.junit.After", "org.junit.jupiter.api.AfterEach"
            ));
            add(new ReplaceAnnotationOnMethods(
                "org.junit.BeforeClass",
                "org.junit.jupiter.api.BeforeAll"
            ));
            add(new ReplaceAnnotationOnMethods(
                "org.junit.AfterClass",
                "org.junit.jupiter.api.AfterAll"
            ));
            add(new ReplaceAnnotationOnMethods(
                "org.junit.Ignore",
                "org.junit.jupiter.api.Disabled"
            ));
        }}, "src/main/java/org/openrewrite/testdata");
    }
}
