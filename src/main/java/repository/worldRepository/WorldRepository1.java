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

public class WorldRepository1 {
    private static final String SELECT_ALL_WORLD_SQL = "SELECT * FROM WORLD ORDER BY DATE_CREATED DESC;";
    public static List<World> getListWorld(){
        List<World> worldList = new ArrayList<>();
        try (Connection connection = ConnectionConfig.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_WORLD_SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("NAME");
                String fantasy = resultSet.getString("FANTASY");
                String author = resultSet.getString("AUTHOR");

                String dateCreate = resultSet.getString("DATE_CREATED");
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, dd / MMMMMMMMM / yyyy |  hh : mm : ss");
                String dateForShow = dateFormat.format(new Date(Long.parseLong(dateCreate)));
                World world = new World(name,fantasy,author,dateForShow,0);
                worldList.add(world);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worldList;
    }

}
