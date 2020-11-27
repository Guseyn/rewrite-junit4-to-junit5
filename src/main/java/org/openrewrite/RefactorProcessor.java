package org.openrewrite;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class RefactorProcessor {
    public static void run(Iterable<RefactorVisitor<?>> visitors, String workingDirectory) throws IOException {
        Iterable<SourceFile> sources = SourceFiles.fromDirectory(workingDirectory);
        Refactor refactor = new Refactor().visit(visitors);
        Collection<Change> changes = refactor.fix(sources);
        for (Change change : changes) {
            Path file = Paths.get(workingDirectory).resolve(change.getOriginal().getSourcePath());
            try (BufferedWriter sourceFileWriter = Files.newBufferedWriter(file)) {
                sourceFileWriter.write(change.getFixed().print());
            }
        }
    }
}
