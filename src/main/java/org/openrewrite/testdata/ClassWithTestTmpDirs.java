package org.openrewrite.testdata;

import java.io.File;
import java.io.IOException;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class ClassWithTestTmpDirs {
    public ClassWithTestTmpDirs() throws IOException {
    }
    ///// case 1 /////
    @Rule
    TemporaryFolder tempDir = new TemporaryFolder();

    ///// case 2 /////
    @Rule
    TemporaryFolder tempDir1 = new TemporaryFolder();
    @Rule
    TemporaryFolder tempDir2 = new TemporaryFolder();
    File file2 = tempDir2.newFile("sam");
    void foo1() throws IOException {
        File file1 = tempDir1.newFile();
    }

    ///// case 3 /////
    void foo2() {
        File root = tempDir.getRoot();
    }

    ///// case 4 /////
    void foo3() throws IOException {
        File file1 = tempDir1.newFolder();
    }

    ///// case 5 /////
    File subDir = tempDir1.newFolder("sub");
    File subDirs = tempDir1.newFolder("foo", "bar", "baz");
}
