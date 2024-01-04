package Task5;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES256 {

     static String encrypt(String text, String key) throws Exception {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, key); // Class Cipher is need for encryption/decryption initialization
        byte[] encryptedBytes = cipher.doFinal(text.getBytes()); //Encrypts the input text using the initialized cipher.
        return Base64.getEncoder().encodeToString(encryptedBytes); //Encodes the encrypted bytes into a Base64 string.
    }

     static String decrypt(String encryptedText, String key) throws Exception {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE, key); // Initializes a cipher in decryption mode using the specified key.
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText); // Decodes the Base64-encoded string into encrypted bytes.
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes); //  Decrypts the input encrypted bytes using the initialized cipher.
        return new String(decryptedBytes);
    }

     static Cipher getCipher(int mode, String key) throws Exception {
        byte[] salt = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};     // 1. Salt is a random value used in the key derivation process.
         int iterationCount = 65536; // 2. Number of iterations for key stretching in PBKDF2.
        int keyLength = 256; // key lengths
        KeySpec keySpec = new PBEKeySpec(key.toCharArray(), salt, iterationCount, keyLength); // Key specification for PBKDF2, using user-provided key, salt, iteration count, and key length.
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); // generating secret key from value
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(mode, secret, new IvParameterSpec(new byte[16]));
        return cipher;
    }
}

