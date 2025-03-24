package org.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class FileEncrypt {

    public static String encryptTextECB(String strToEncrypt, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
        byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static void encryptFileECB(int cipherMode, String secretKeyStr, File fileIn, File fileOut) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        try{
            Key secretKey = new SecretKeySpec(secretKeyStr.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            byte[] encryptedBytes = cipher.doFinal(readFileToBytes(fileIn.getPath()));
            writeBytesToFile(fileOut.getPath(), encryptedBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] readFileToBytes(String filePath) throws IOException{
        return Files.readAllBytes(Path.of(filePath));
    }

    public static void writeBytesToFile(String filePath, byte[] data) throws IOException {
        Files.write(Path.of(filePath), data);
    }
}
