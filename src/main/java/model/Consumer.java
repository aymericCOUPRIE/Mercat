package model;

import java.util.*;

/**
 * 
 */
public class Consumer extends User {

    /**
     *This method permits to instantiate a consumer
     * @param pseudo of the consumer
     * @param firstName of the consumer
     * @param lastName of the consumer
     * @param password of the consumer
     * @param emailAddress of the consumer
     * @param streetAddress of the consumer
     * @param city of the consumer
     * @param postalCode of the consumer
     * @param pictureUser of the consumer
     * @param role of the consumer
     * @param phoneNumber of the consumer
     */
    public Consumer(String pseudo, String firstName, String lastName, String password, String emailAddress, String streetAddress, String city, String postalCode, String pictureUser, String role, String phoneNumber) {
        super(pseudo, firstName, lastName, password, emailAddress, streetAddress, city, postalCode, pictureUser, role, phoneNumber);
    }
}