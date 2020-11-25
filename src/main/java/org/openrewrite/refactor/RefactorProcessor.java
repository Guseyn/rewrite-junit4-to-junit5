package org.openrewrite.refactor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import org.openrewrite.Change;
import org.openrewrite.Refactor;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.SourceFile;

public class RefactorProcessor {
    public static void run(Iterable<RefactorVisitor<?>> visitors, String workingDirectory) throws IOException {
        Iterable<SourceFile> sources = SourceFiles.fromDirectory(workingDirectory);
        Refactor refactor = new Refactor().visit(visitors);
        Collection<Change> changes = refactor.fix(sources);
        for (Change change : changes) {
            Path file = Paths.get(change.getOriginal().toString());
            try (BufferedWriter sourceFileWriter = Files.newBufferedWriter(file)) {
                sourceFileWriter.write(change.getFixed().print());
            }
        }
    }
}
