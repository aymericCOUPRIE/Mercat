package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CheckInfosUser {

    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static String checkInfosConsumer(String pseudo,String email, String password, String phoneNumber, String street, String postal, String city){
        if((pseudo.equals("") || password.equals("") || phoneNumber.equals("") || street.equals("") || postal.equals("") || city.equals("") || email.equals(""))){
            return "You need to provide every information";
        }else{
            if (password.length() < 8) {
                return  "Your password must have at least 8 characters";
            } else {
                String test = "0" + Integer.parseInt(phoneNumber);
                if (phoneNumber.matches("[0-9]+")&&(phoneNumber.length() == 10 || phoneNumber.length() == 12)) {
                    Matcher matcher = pattern.matcher(email);
                    if(matcher.matches()){
                        return "OK";
                    }else{
                       return  "Your email is incorrect";

                    }
                } else {
                    return "Your phone number is incorrect";
                }
            }
        }

    }

}
