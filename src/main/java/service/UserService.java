package service;

import model.user.User;
import repository.userRepository.UserRepository;
import ulti.ValidateUlti;

public class UserService {
    public static boolean updateUser(User user){
        boolean isPasswordValid = ValidateUlti.validate(user.getPassword(), "PASSWORD");
        boolean isNameValid = ValidateUlti.validate(user.getName(), "NAME");
        boolean isEmailValid = ValidateUlti.validate(user.getEmail(), "EMAIL");
        boolean isUpdateSucceed = false;
        if (isPasswordValid && isNameValid && isEmailValid) {
            UserRepository.getInstance().updateUser(user);
            isUpdateSucceed = true;
        }
        return isUpdateSucceed;
    }

    public static String hideEmail(User user) {
        String userEmail = user.getEmail();
        String[] string = userEmail.split("@");
        String emailString;
        String headEmailString = string[0];
        String botEmailString = '@' + string[1];
        String[] subHeadEmailString = headEmailString.split("");
        if (headEmailString.length() <6){
            emailString = subHeadEmailString[0];
            for (int i=1; i<headEmailString.length(); i++){
                emailString += "&#x2022";
            }
        }else {
            emailString = subHeadEmailString[1] + subHeadEmailString[2];
            for (int i=2; i<headEmailString.length(); i++){
                emailString += "&#x2022";
            }
        }
        emailString += botEmailString;
        return emailString;
    }

    public static String hidePassword (User user){
        String userPassword = user.getPassword();
        String passwordString = "";
        for (int i=0; i<userPassword.length(); i++){
            passwordString += "&#x2022";
        }
        return passwordString;
    }
}
