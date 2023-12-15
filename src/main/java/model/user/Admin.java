package model.user;

import constant.Role_Constant;

public class Admin extends User {
    public Admin() {
    }

    public Admin(String user, String password, String name, String email) {
        super(user, password, name, email);
        super.role = Role_Constant.ADMIN_ROLE;
    }

    public Admin(int id, String user, String password, String name, String email, String avatar) {
        super(id, user, password, name, email, avatar);
        super.role = Role_Constant.ADMIN_ROLE;
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
