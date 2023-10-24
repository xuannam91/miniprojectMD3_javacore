import controller.UserView;
import fileservice.UserFileService;
import model.User;
import service.UserLoginRegister;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserFileService userFileService = new UserFileService();
        UserLoginRegister userLoginRegister = new UserLoginRegister(userFileService);
        User user = new User();
        UserView userView = new UserView(userLoginRegister,user);
        userView.loginOrRegister(scanner);
    }
}