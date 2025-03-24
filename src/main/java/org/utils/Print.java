package org.utils;

import java.util.List;

public class Print {
    private String message = "";

    public Print(String message) {
        this.message = message;
    }

    public Print(List<String> messages) {
        for (String str : messages) {
            this.message += str + "\n";
        }
    }

    public static void printConsole(String message) {
        System.out.println(message);
    }

    public static void printConsoleLineBreak() {
        System.out.println();
    }

}
