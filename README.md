# Exercise 1: File Encryption and Decryption Utility

## Description
Create a utility that encrypts and decrypts the output files from the previous levels.

Use the AES algorithm in ECB (Electronic Codebook) or CBC (Cipher Block Chaining) mode with PKCS5Padding for padding. You may use either the `javax.crypto` package or the `org.apache.commons.crypto` library.

## Requirements
- Implement methods to:
  - Encrypt a file and generate an encrypted output.
  - Decrypt an encrypted file and restore the original content.
- Support AES encryption in ECB or CBC mode.
- Use PKCS5Padding for proper padding.
- Accept the encryption key and mode (ECB or CBC) as configurable parameters.
- Ensure compatibility with files generated in previous exercises.

## Compilation Instructions

1. Compile the project:

```bash
javac -d out -cp . src/*.java
```

## Configuration File (Config.properties)
Customize default values via the `Config.properties` file:

```
PATH_IN=/src/main/resources/FileDir/
PATH_OUT=Result.txt
PATH_OUT_ENCRYPT=Result_Encrypt.txt
PATH_OUT_DECRYPT=Result_Decrypt.txt
AES_KEY=1234567890123456
```

## Notes
- Ensure the AES key length meets valid requirements (16, 24, or 32 bytes).
- Always verify the integrity of decrypted content.

