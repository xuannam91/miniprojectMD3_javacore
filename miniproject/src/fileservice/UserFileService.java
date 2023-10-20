package fileservice;

import data.Data;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileService {
    private static List<User> users;
    private Data<User> userData = new Data();

    public UserFileService() {
        List<User> userList = userData.readFromFile(Data.USER_DATA);
        if (userList == null) {
            userList = new ArrayList<>();
        }
        this.users = userList;
    }

    public List<User> getAllUser() {
        return users;
    }


    public void saveToFile(User user) {
        if (findById(user.getId()) == null) {
            users.add(user);
        } else {
            users.set(users.indexOf(findById(user.getId())), user);
        }
        userData.writeToFile(users, Data.USER_DATA);

    }


    public User getUserByUsername(String userName, String password) {
        for (User user : this.users) {
            if (user.getUsername().trim().equals(userName) && user.getPassword().trim().equals(password)) {
                return user;
            }
        }
        return null;
    }


    public User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

}
