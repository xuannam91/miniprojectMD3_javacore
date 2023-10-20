package service;

import fileservice.UserFileService;
import model.User;

import java.util.ArrayList;
import java.util.List;


public class UserLoginRegister {
    private final UserFileService userFileService;
    private List<User> allUser = new ArrayList<>();

    public UserLoginRegister(UserFileService userFileService) {
        this.userFileService = userFileService;
    }


    public int autoInc() {
        int max = 0;
        for (User u : userFileService.getAllUser()) {
            if (max < u.getId()) {
                max = u.getId();
            }
        }
        return max+1;
    }

    public void saveUser(User user) {
        userFileService.saveToFile(user);
    }

    public User login(String username, String password) {
        User user = userFileService.getUserByUsername(username,password);
        if(user!= null && user.isStatus()){
            return user;
        }
        return null;
    }
}
