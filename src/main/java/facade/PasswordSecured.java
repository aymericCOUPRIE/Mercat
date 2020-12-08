package facade;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordSecured{
    private static byte[] salt = new byte[16];
    private static Random random = new SecureRandom();
    private static String passwordSecured;

    public PasswordSecured(){
    }

    public static String getPasswordSecured() {
        return passwordSecured;
    }


    public static void hash(String passwordToHash) {
         random.nextBytes(salt);
         try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
             byte[] hashedPassword = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
             String password = Base64.getEncoder().encodeToString(hashedPassword);
             passwordSecured = password;
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }
    }

    public boolean isTheSamePassword(String passwordToCheck, String realPassword) throws NoSuchAlgorithmException {
        hash(passwordToCheck);
        return passwordSecured==realPassword;
    }
}