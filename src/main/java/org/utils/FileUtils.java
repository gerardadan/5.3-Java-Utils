package org.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtils {

    public static String getRootPath() {
        return Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
    }

    public static String getProjectPath() throws IllegalArgumentException {
        String filePath = System.getProperty("user.dir");
        File file = new File(filePath);

        return file.getAbsolutePath();
    }

    public static String getAbsoluteFilePath(String path) throws IllegalArgumentException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not exist : " + path);
        }

        return file.getAbsolutePath();
    }

    public static File[] getAllFilesFromDir(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            return dir.listFiles();
        } else {
            return new File[0];
        }
    }
}