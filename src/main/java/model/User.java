package model;

import java.util.*;

/**
 * Class User
 */
public class User {

    private String pseudo;
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String pictureUser;
    private String phoneNumber;
    private String role;


    /**
     * @param pseudo        of the user
     * @param firstName     of the user
     * @param lastName      of the user
     * @param password      of the user
     * @param emailAddress  of the user
     * @param streetAddress of the user
     * @param city          of the user
     * @param postalCode    of the user
     * @param pictureUser   of the user
     * @param role          of the user
     * @param phoneNumber   of the user
     */
    public User(String pseudo, String firstName, String lastName, String password, String emailAddress, String streetAddress, String city, String postalCode, String pictureUser, String role, String phoneNumber) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.pictureUser = pictureUser;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }


    /**
     * GETTER
     *
     * @return the pseudo of the user
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * SETTER
     *
     * @param pseudo modifies the pseudo of the user
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * GETTER
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * SETTER
     *
     * @param firstName modifies the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * GETTER
     *
     * @return the last ame of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * SETTER
     *
     * @param lastName modifies the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * GETTER
     *
     * @return the password (hashed) of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * SETTER
     *
     * @param password modifies the password (hashed) of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * GETTER
     *
     * @return the mail of the user
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * SETTER
     *
     * @param emailAddress modifies the mail of the user
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * GETTER
     *
     * @return the address of the user
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * SETTER
     *
     * @param streetAddress modifies te address of the user
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * GETTER
     *
     * @return the city of the user
     */
    public String getCity() {
        return city;
    }

    /**
     * SETTER
     *
     * @param city modifies the city of the user
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * GETTER
     *
     * @return the postal code of the user
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * SETTER
     *
     * @param postalCode modifies the postal of the user
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * GETTER
     * NOT USED (no image)
     *
     * @return the profil picture of he user
     */
    public String getPictureUser() {
        return pictureUser;
    }

    /**
     * SETTER
     * NOT USED (no image)
     *
     * @param pictureUser modifies the profil picture of the user
     */
    public void setPictureUser(String pictureUser) {
        this.pictureUser = pictureUser;
    }

    /**
     * GETTER
     *
     * @return the role of he user (consumer/seller/admin)
     */
    public String getRole() {
        return role;
    }

    /**
     * SETTER
     *
     * @param role gives the role to the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * GETTER
     *
     * @return the phone number of the user
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * SETTER
     *
     * @param phoneNumber modifies the phone number of the user
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}