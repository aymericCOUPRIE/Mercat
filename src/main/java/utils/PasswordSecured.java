package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * Class PasswordSecured
 * This class is used to crypt the password and verif password
 */
public class PasswordSecured {
    private static byte[] salt = new byte[16];
    private static Random random = new SecureRandom();

    private PasswordSecured() {
    }

    /**
     * This method is used to hash the password when loging
     *
     * @param passwordToHash password in clear
     * @return the hashed password
     */
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


    /**
     * This method is used to check 2 different password
     *
     * @param passwordToCheck password in clear
     * @param realPassword    password in hash (from the database)
     * @return true is the 2 passwords match, false if they don't
     */
    public static boolean isTheSamePassword(String passwordToCheck, String realPassword) {
        return hash(passwordToCheck).equals(realPassword);
    }

}