package org.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileLister extends FileUtils {

    public static List<File> listFiles(String path, SortOrder sortOrder) {
        List<File> files = new ArrayList<>(List.of(FileUtils.getAllFilesFromDir(new File(path))));
        Collections.sort(files);
        if (sortOrder == SortOrder.DESC) {
            files.sort(Collections.reverseOrder());
        }

        return files;
    }

}
