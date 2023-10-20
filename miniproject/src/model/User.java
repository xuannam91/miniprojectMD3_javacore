package model;

import java.io.Serializable;

import static constant.Constant.Role.ADMIN;
import static constant.Constant.Status.ACTIVE;

public class User implements Serializable {
    private static final long serialVersionUID = 1l;
    private int id;
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private boolean status;
    private int role;

    public User() {
    }

    public User(int id, String username, String fullName, String email, String password, String address, String phone, boolean status, int role) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", status=").append(status == ACTIVE ? "'ACTIVE'" : "'BLOCK'");
        sb.append(", role=").append(role == ADMIN ? "'ADMIN'" : "'USER'");
        sb.append('}');
        return sb.toString();
    }
}
