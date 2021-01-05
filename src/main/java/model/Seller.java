package model;

/**
 * 
 */
public class Seller extends User {

    /**
     * Default constructor
     */
    public Seller(String pseudo, String firstName, String lastName, String password, String emailAddress, String streetAddress, String city, String postalCode, String pictureUser, String role, String phoneNumber, String companyName) {
        super(pseudo, firstName, lastName, password, emailAddress, streetAddress, city, postalCode, pictureUser, role, phoneNumber);
        this.companyName = companyName;
    }

    /**
     * 
     */
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}