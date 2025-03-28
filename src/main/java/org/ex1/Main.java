package org.ex1;

import org.utils.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            String rootPath = FileUtils.getRootPath();
            loadProperties(properties, rootPath + "configuration.properties");

            String pathIn = properties.get("PATH_IN").toString();
            String pathOut = properties.get("PATH_OUT").toString();
            String pathOutEncrypt = properties.get("PATH_OUT_ENCRYPT").toString();
            String pathOutDecrypt = properties.get("PATH_OUT_DECRYPT").toString();
            String secretKey = properties.get("AES_KEY").toString();

            pathIn = FileUtils.getAbsoluteFilePath(FileUtils.getProjectPath() + pathIn);
            writeFileList(FileLister.listFiles(pathIn, SortOrder.ASC), rootPath + pathOut);

            encryptFile(Cipher.ENCRYPT_MODE, secretKey, new File(rootPath + pathOut), new File(rootPath + pathOutEncrypt));
            encryptFile(Cipher.DECRYPT_MODE, secretKey, new File(rootPath + pathOutEncrypt), new File(rootPath + pathOutDecrypt));
        } catch (IOException e) {
            new Print("Path don't exist");
            throw new RuntimeException(e);
        }
    }

    private static void loadProperties(Properties properties, String path) throws IOException {
        try (FileInputStream input = new FileInputStream(path)) {
            properties.load(input);
        }
    }

    private static void encryptFile(int cipherMode, String secretKey, File fileIn, File fileOut) {
        try {
            FileEncrypt.encryptFileECB(cipherMode, secretKey, fileIn, fileOut);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException e) {
            Print.printConsole("Error encryptFile: " + e);
            throw new RuntimeException(e);
        }
    }

    private static String encryptText(String text, String secretKey) {
        try {
            return FileEncrypt.encryptTextECB(text, secretKey);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException e) {
            Print.printConsole("Error encryptText: " + e);
            throw new RuntimeException(e);
        }
    }

    private static void writeFileList(List<File> files, String outPath) {
        try {
            PrintStream printStream = new PrintStream(outPath);
            FilePrint.printFiles(files, printStream, 0);
        } catch (FileNotFoundException e) {
            Print.printConsole("Error writeFileList: " + e);
            throw new RuntimeException(e);
        }
    }

}