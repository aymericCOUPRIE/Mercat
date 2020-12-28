package facade;

import dao.AbstractFactoryDAO;
import dao.UserDAO;
import model.Consumer;
import model.Seller;
import model.User;
import router.Router;

import java.util.*;

/**
 *
 */
public class UserFacade {

    private static User user;

    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private UserDAO userDAO = af.createUserDAO();


    //notre façade est un singleton
    private static UserFacade instanceUserFacade;

    /**
     * @return instanceUserFacade
     **/

    public static UserFacade getInstanceUserFacade() {
        if (instanceUserFacade == null) {
            instanceUserFacade = new UserFacade();
        }
        return instanceUserFacade;
    }

    /**
     * Default constructor du singleton façade
     */
    public UserFacade() {
    }



    /**
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param password
     * @param emailAdress
     * @param streetAddress
     * @param city
     * @param postalCode
     * @return
     */
    public boolean signUpConsumer(String pseudo, String firstName, String lastName, String password, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber) {
        Consumer userConsumer = new Consumer(pseudo,firstName,lastName,password,emailAdress,streetAddress,city,postalCode,"","consumer", phoneNumber);
        return userDAO.createConsumer(userConsumer);
    }

    /**
     * @param pseudo
     * @param password
     * @return boolean true si connection réussie, false sinon
     */
    public void login(String pseudo, String password) {
        user = userDAO.login(pseudo, password);
        UserFacade.getInstanceUserFacade().setConnectedUser(user);
    }

    /**
     * @return boolean, true si l'utilisateur est connecté
     */
    public boolean isConnected() {
        return user != null;
    }

    /**
     * @param pseudo
     * @param password
     * @param emailAdress
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param phoneNumber
     * @param companyName
     * @return
     */
    public boolean signUpSeller(String pseudo, String firstName, String lastName, String password, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String companyName) {
        Seller userSeller = new Seller(pseudo,firstName,lastName,password,emailAdress,streetAddress,city,postalCode,"","seller", phoneNumber, companyName);
        return userDAO.createSeller(userSeller);
    }

    /**
     * @param
     * @return
     */
    public boolean updateUser(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber) {
        if(isSeller()){
            //flo ton code pour modifier un seller
            return false; //a enlever
        }else{//je suis un consumer ou un admin

            return userDAO.updateConsumer( pseudo,firstName, lastName, password,OldPassword, emailAdress, streetAddress, city, postalCode,phoneNumber);
        }

    }

    /**
     * @param newUser attribue à la façade le user qui vient de se connecter
     */
    public void setConnectedUser(User newUser) {
        user = newUser;
    }

    /**
     * @return User qui est connecté en ce moment
     */
    public static User getConnectedUser() {
        return user;
    }

    /**
     * @return boolean true if the current user is an admin, else false
     */
    public static boolean isAdmin() {
       return getConnectedUser().getRole().equals("admin");
    }

    /**
     * @return boolean true if the current user is a seller, else false
     */
    public static boolean isSeller(){
        return getConnectedUser().getRole().equals("seller");
    }

    /**
     * This methode permit to delete an user from the dataBase
     * It is the same methode for all the kind of user
     * @param pseudo
     */

    public boolean deleteUser(String pseudo){
        return userDAO.deleteUser(pseudo);
    }



    /**
     * this method is used to get all the informations about a consumer
     * @return User
     */
    public User getConsumerDetails() {
        if(isAdmin()){

            return userDAO.findUser((String) Router.getInstance().getParams()[0]);

        } else {//je suis un consumer
            return  getConnectedUser();
        }

    }

    /**
     * @return
     */
    public ArrayList<String> getAllConsumerPseudo() {

        return userDAO.getAllPseudo("consumer");
    }


    /**
     * Fonction qui retourne le pseudo de l'user recherché ou un message d'erreur si il n'existe pas ou que ce n'est pas un consumer
     * @param pseudo
     * @return String pseudo ou errormsg
     */

    public String searchConsumer(String pseudo){

        return userDAO.searchConsumer(pseudo);
    }

    /**
     * @param pseudo
     * @return
     */
    public Seller getSellerDetails(String pseudo) {
        // TODO implement here
        // Flo tu peut te servir de getConsumerDetails je pense, faudrait la renomer getUserDetails dans mon code du coup
        return null;
    }

    /**
     * @return
     */
    public Set<String> getAllSellersPseudo() {
        // TODO implement here
        return null;
    }


}