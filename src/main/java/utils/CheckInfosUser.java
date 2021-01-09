package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CheckInfosUser {

    /**
     * these constants will be used to check the email format.
     */
    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    /**
     * This function verifies that the user has filled in all the fields as well as their format.
     * @param pseudo of the user who registers or whose data you want to modify
     * @param email of the user who registers or whose data you want to modify
     * @param firstname of the user who registers or whose data you want to modify
     * @param lastname of the user who registers or whose data you want to modify
     * @param password of the user who registers or whose data you want to modify
     * @param phoneNumber of the user who registers or whose data you want to modify
     * @param street of the user who registers or whose data you want to modify
     * @param postal of the user who registers or whose data you want to modify
     * @param city of the user who registers or whose data you want to modify
     * @return an error describing the parameter which is not in the right format or mentioning that at least one field has not been filled in or ok if everything is ok
     */
    public static String checkInfosConsumer(String pseudo,String email,String firstname, String lastname, String password, String phoneNumber, String street, String postal, String city){
        if((pseudo.equals("") || password.equals("") || phoneNumber.equals("") || street.equals("") || postal.equals("") || city.equals("") || email.equals("")|| firstname.equals("")|| lastname.equals(""))){
            return "You need to provide every information";
        }else{
            if(passwordNotNull(password)) {
                if (phoneNumber.matches("[0-9]+") && (phoneNumber.length() == 10 || phoneNumber.length() == 12)) {
                    Matcher matcher = pattern.matcher(email);
                    if (matcher.matches()) {
                        if(postal.matches("[0-9]+")&&(postal.length()==5)){
                            return "Ok";
                        }else{
                            return "Your postal code is invalid";
                        }
                    } else {
                        return "Your email is incorrect";
                    }
                } else {
                    return "Your phone number is incorrect";
                }
            }
        }
    }

    /**
     *
     * @param pseudo
     * @param email
     * @param firstname
     * @param lastname
     * @param password
     * @param phoneNumber
     * @param street
     * @param postal
     * @param city
     * @param companyName
     * @return
     */
    public static String checkInfosSeller(String pseudo,String email,String firstname, String lastname, String password, String phoneNumber, String street, String postal, String city, String companyName){
        if(companyName.equals("")){
            return "You need to provide every information";
        }else{
            return checkInfosConsumer(pseudo,email,firstname,lastname,password,phoneNumber,street,postal,city);
        }
    }

    /**
     * @param p the password to check
     * @return true if there is no space into the password
     */
    private static boolean passwordNotNull(String p){
        return p.indexOf(" ")==-1;
    }
}
