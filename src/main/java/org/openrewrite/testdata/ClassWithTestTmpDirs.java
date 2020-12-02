package org.openrewrite.testdata;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ClassWithTestTmpDirs {
    public ClassWithTestTmpDirs() throws IOException {
    }
    ///// case 1 /////
    @TempDir
    File tempDir;

    ///// case 2 /////
    @TempDir
    File tempDir1;
    @TempDir
    File tempDir2;
    File file2 = newFile(tempDir2, "sam");
    void foo1() throws IOException {
        File file1 = File.createTempFile("junit", null, tempDir1);
    }

    ///// case 3 /////
    void foo2() {
        File root = tempDir;
    }

    ///// case 4 /////
    void foo3() throws IOException {
        File file1 = Files.createTempDirectory(tempDir1.toPath(), "junit").toFile();
    }

    ///// case 5 /////
    File subDir = newFolder(tempDir1, "sub");
    File subDirs = newFolder(tempDir1, "foo", "bar", "baz");

    private static File newFolder(File root, String ... folders) throws IOException {
        File result = new File(root, String.join("/", folders));
        if(!result.mkdirs()) {
            throw new IOException("Couldn't create folders " + root);
        }
        return result;
    }

    private static File newFile(File root, String fileName) throws IOException {
        File file = new File(root, fileName);
        file.createNewFile();
        return file;
    }
}
