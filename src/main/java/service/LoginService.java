package service;

import model.user.User;
import repository.userRepository.UserRepository;

public class LoginService {

    public static User login(String username, String password){
        User user = UserRepository.getInstance().getUserByUserName(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
