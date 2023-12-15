package service;

import model.multiWorld.World;
import model.user.User;
import model.user.Wibu;
import repository.worldRepository.WorldRepository;

public class WorldService {
    public static void createWorld(String worldName, String worldFantasy, User currentWibu, int userID) {
        World newWorld = new World(worldName,worldFantasy,currentWibu,userID);
        WorldRepository.createWorld(newWorld);
    }
}
