package model;

import java.util.*;

/**
 *
 */
public class User {

    /**
     *
     */
    private String pseudo;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String emailAddress;

    /**
     *
     */
    private String streetAddress;

    /**
     *
     */
    private String city;

    /**
     *
     */
    private String postalCode;

    /**
     *
     */
    private String pictureUser;


    /**
     *
     */
    private String phoneNumber;

    /**
     *
     */
    private String role;



    /**
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param password
     * @param emailAddress
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param pictureUser
     * @param role
     * @param phoneNumber
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




    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPictureUser() {
        return pictureUser;
    }

    public void setPictureUser(String pictureUser) {
        this.pictureUser = pictureUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + pseudo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", pictureUser='" + pictureUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}