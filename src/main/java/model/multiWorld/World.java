package model.multiWorld;

import model.user.User;
import model.user.Wibu;

public class World extends MultiWorld {
    private int id;
    private String name;
    private String fantasy;
    private String author;
    private final long dateCreated;
    private String dateForShow;
    private int userID;
    public World() {   //Biến final phải được gán giá trị khi tạo đối tượng nếu không sẽ gây ra lỗi

        dateCreated = System.currentTimeMillis();
    }
    public World(String name, String fantasy, User currentUser) {
        this.name = name;
        this.fantasy = fantasy;
        this.author = currentUser.getName();
        dateCreated = System.currentTimeMillis();
    }

    public World(String worldName, String worldFantasy, User currentUser, int userID) {
        this.name = worldName;
        this.fantasy = worldFantasy;
        this.author = currentUser.getName();
        this.dateCreated = System.currentTimeMillis();
        this.userID = userID;
    }


//    public World(int id, String name, String fantasy, String author, String dateCreated) {
//        this.id = id;
//        this.name = name;
//        this.fantasy = fantasy;
//        this.author = author;
//        this.dateCreated = Long.parseLong(dateCreated);
//    }
    public World(String name, String fantasy, String author, String dateForShow, long dateCreated){
        this.name = name;
        this.fantasy = fantasy;
        this.author = author;
        this.dateForShow = dateForShow;
        this.dateCreated = dateCreated;
    }


//    public World(int id, String name, String fantasy, String author, String dateCreated, int userID) {
//        this.id = id;
//        this.name = name;
//        this.fantasy = fantasy;
//        this.author = author;
//        this.dateCreated = Long.parseLong(dateCreated);
//        this.userID = userID;
//    }
//
//    public World(String name, String fantasy, String author, String dateCreated, int userID) {
//        this.id = id;
//        this.name = name;
//        this.fantasy = fantasy;
//        this.author = author;
//        this.userID = userID;
//        this.dateCreated = Long.parseLong(dateCreated);
//    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFantasy() {
        return fantasy;
    }

    public void setFantasy(String fantasy) {
        this.fantasy = fantasy;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public int getUserID() {
        return userID;
    }

    public String getDateForShow() {
        return dateForShow;
    }

    @Override
    public String toString() {
        return "World{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fantasy='" + fantasy + '\'' +
                ", author='" + author + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
