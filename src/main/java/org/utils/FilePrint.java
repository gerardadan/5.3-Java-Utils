package org.utils;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FilePrint {

    public static void printFiles(List<File> files, PrintStream printStrem, int index) {
        Collections.sort(files);
        for (File file : files) {
            printStrem.println(FileFormatter.formatFile(file, index));
            if (file.isDirectory()) {
                List<File> filesNode = new ArrayList<>(List.of(Objects.requireNonNull(file.listFiles())));
                printFiles(filesNode, printStrem, index + 1);
            }
        }
    }

}
