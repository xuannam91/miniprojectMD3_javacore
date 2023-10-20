import controller.UserView;
import fileservice.UserFileService;
import service.UserLoginRegister;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserFileService userFileService = new UserFileService();
        UserLoginRegister userLoginRegister = new UserLoginRegister(userFileService);
        UserView userView = new UserView(userLoginRegister);
        userView.loginOrRegister(scanner);
    }
}