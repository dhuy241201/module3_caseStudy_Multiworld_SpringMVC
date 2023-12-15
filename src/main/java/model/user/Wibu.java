package model.user;

import constant.Role_Constant;

public class Wibu extends User {

//    private int id;
//    private String username;
//    private String password;
//    private String name;
//    private String email;
//    private String avatar;
//    protected int role;
//
//    public Wibu(User user) {
//        // sao chép các thuộc tính của user vào this
//        this.setID() = user.getId();
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.name = user.getName();
//        this.email = user.getEmail();
//        this.avatar = user.getAvatar();
//    }


    public Wibu(String user, String password, String name, String email) {
        super(user, password, name, email);
        super.role = Role_Constant.WIBU_ROLE;
    }

    public Wibu(int id, String user, String password, String name, String email, String avatar) {
        super(id, user, password, name, email, avatar);
        super.role = Role_Constant.WIBU_ROLE;
    }

    public Wibu(int id, String password, String name, String email, String avatar) {
        super(id, password, name, email, avatar);
    }



    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(int role) {
        super.setRole(role);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
