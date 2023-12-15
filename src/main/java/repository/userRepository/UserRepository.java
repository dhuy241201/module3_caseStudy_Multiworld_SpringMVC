package repository.userRepository;

import model.user.User;
import repository.connection.ConnectionConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository implements IUserRepository {
    private static UserRepository userRepository = null;
    private final String INSERT_NEW_USER_SQL = "INSERT INTO USER (USERNAME, PASSWORD, NAME, EMAIL) VALUE (?,?,?,?);";
    private final String GET_USER_SQL = "SELECT * FROM USER WHERE USERNAME = ?";
    //    private final String SELECT_USER_SQL = "SELECT * FROM USER WHERE ID = ?;";
    private final String UPDATE_USER_SQL = "UPDATE USER SET PASSWORD = ?, NAME = ?, EMAIL = ?, AVATAR = ? WHERE ID=?;";

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    public void insertUser(User user) {
        try (Connection connection = ConnectionConfig.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER_SQL)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getEmail());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUserName(String username) {
        User user = null;
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER_SQL)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String avatar = resultSet.getString("avatar");
                user = new User(id, username, password, name, email,avatar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = ConnectionConfig.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
                statement.setString(1, user.getPassword());
                statement.setString(2, user.getName());
                statement.setString(3, user.getEmail());
                statement.setString(4,user.getAvatar());
                statement.setInt(5,user.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
