package model;

import java.util.*;

/**
 * 
 */
public class Consumer extends User {

    /**
     * Default constructor
     */
    public Consumer(String login, String firstName, String lastName, String password, String emailAddress, String streetAddress, String city, String postalCode, String pictureUser, String role, String phoneNumber) {
        super(login, firstName, lastName, password, emailAddress, streetAddress, city, postalCode, pictureUser, role, phoneNumber);
    }
}