package service;

import model.user.User;
import repository.userRepository.UserRepository;

public class RegisterService {

    public static boolean register(String username, String password, String name, String email){
        boolean isRegisterSucceed = false;

        if (UserRepository.getInstance().getUserByUserName(username) == null){
            User newUser = new User(username,password,name,email);
            UserRepository.getInstance().insertUser(newUser);
            isRegisterSucceed = true;
        }
        return isRegisterSucceed;
    }
}
