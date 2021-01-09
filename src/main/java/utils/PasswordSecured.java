package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordSecured{
    private static byte[] salt = new byte[16];
    private static Random random = new SecureRandom();

    private PasswordSecured(){
    }

    public static String hash(String passwordToHash) {
        random.nextBytes(salt);
         try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
             byte[] hashedPassword = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
             return Base64.getEncoder().encodeToString(hashedPassword);
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }
         return null;
    }


    public static boolean isTheSamePassword(String passwordToCheck, String realPassword) throws NoSuchAlgorithmException {
        return hash(passwordToCheck).equals(realPassword);
    }

}