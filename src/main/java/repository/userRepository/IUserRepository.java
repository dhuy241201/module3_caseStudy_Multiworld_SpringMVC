package repository.userRepository;

import model.user.User;

import java.sql.SQLException;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User getUserByUserName(String username);
    public void updateUser(User user) throws SQLException;
}
