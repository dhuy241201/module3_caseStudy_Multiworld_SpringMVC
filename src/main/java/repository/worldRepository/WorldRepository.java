package repository.worldRepository;

import model.multiWorld.World;
import repository.connection.ConnectionConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorldRepository {
    private static final String CREATE_NEW_WORLD_SQL = "INSERT INTO `WORLD`(NAME, FANTASY, AUTHOR, DATE_CREATED, USER_ID) VALUE (?,?,?,?,?);";
    private static final String SELECT_ALL_WORLD_SQL = "SELECT * FROM WORLD ORDER BY DATE_CREATED DESC;";
    public static void createWorld(World newWorld) {
        try (Connection connection = ConnectionConfig.getConnection(); PreparedStatement statement = connection.prepareStatement(CREATE_NEW_WORLD_SQL)) {
            statement.setString(1, newWorld.getName());
            statement.setString(2, newWorld.getFantasy());
            statement.setString(3, newWorld.getAuthor());
            statement.setLong(4, newWorld.getDateCreated());
            statement.setLong(5,newWorld.getUserID());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
