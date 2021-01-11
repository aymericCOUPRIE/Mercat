package model;

/**
 * Class Seller
 */
public class Seller extends User {

    /**
     * CONSTRUCTOR
     *
     * @param pseudo        of the seller
     * @param firstName     of the seller
     * @param lastName      of the seller
     * @param password      of the seller
     * @param emailAddress  of the seller
     * @param streetAddress of the seller
     * @param city          of the seller
     * @param postalCode    of the seller
     * @param pictureUser   of the seller
     * @param role          of the seller
     * @param phoneNumber   of the seller
     * @param companyName   of the seller
     */
    public Seller(String pseudo, String firstName, String lastName, String password, String emailAddress, String streetAddress, String city, String postalCode, String pictureUser, String role, String phoneNumber, String companyName) {
        super(pseudo, firstName, lastName, password, emailAddress, streetAddress, city, postalCode, pictureUser, role, phoneNumber);
        this.companyName = companyName;
    }

    private String companyName;

    /**
     * GETTER
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * SETTER
     *
     * @param companyName modifies the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}