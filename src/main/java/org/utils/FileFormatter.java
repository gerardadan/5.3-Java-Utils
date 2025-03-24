package org.utils;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileFormatter {

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatFile(File file, int index) {
        String message = "";
        if (file.isFile()) {
            message = file.getName() + (" - (F) - ") + dateFormat.format(file.lastModified());
        } else if (file.isDirectory()) {
            message = file.getName() + (" - (D) - ") + dateFormat.format(file.lastModified());
        }
        
        return ("---".repeat(Math.max(0, index)) + message);
    }
}
