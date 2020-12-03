package model;

import java.util.*;

/**
 * 
 */
public class User {

    public User(String login, String firstName, String lastName, String password, String emailAddress, String streetAddress, String city, String postalCode, String pictureUser, String role) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.pictureUser = pictureUser;
        this.role = role;
    }

    /**
     * 
     */
    private String login;

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
    private String role;


    /**
     * @return
     */
    public void login() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void signUp() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void updateInformation() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void deleteAccount() {
        // TODO implement here
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", pictureUser='" + pictureUser + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}