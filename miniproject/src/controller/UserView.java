package controller;

import constant.Constant;
import model.User;
import service.UserLoginRegister;

import java.util.InputMismatchException;
import java.util.Scanner;

import static constant.Constant.Status.ACTIVE;
import static service.AdminManagementService.*;
import static validate.Validate.*;

public class UserView {
    private UserLoginRegister userLoginRegister;

    public UserView(UserLoginRegister userLoginRegister) {
        this.userLoginRegister = userLoginRegister;
    }

    public void loginOrRegister(Scanner scanner) {
       try {
           do {
               System.out.println("Bạn cần đăng nhập hoặc đăng ký để sử dụng dịch vụ");
               System.out.println("Lựa chọn của bạn? (1: Đăng nhập, 2: Đăng ký)");
               int choice = Integer.parseInt(scanner.nextLine());
               User user;
               switch (choice) {
                   case 1:
                       System.out.println("Hãy thực hiện đăng nhập");
                       System.out.println("Username:");
                       String username = scanner.nextLine();
                       System.out.println("Password:");
                       String password = scanner.nextLine();
                       user = userLoginRegister.login(username, password);
                       if (user != null) {
                           if (user.getRole() == Constant.Role.ADMIN) {
                               displayAdminMenu(scanner);
                           } else {
                               displayUserMenu(scanner, user);
                           }
                       } else {
                           System.out.println("Đăng nhập thất bại");
                           loginOrRegister(scanner);
                       }
                       break;
                   case 2:
                       user = registerUser(scanner);
                       userLoginRegister.saveUser(user);
                       loginOrRegister(scanner);
                       break;
                   default:
                       System.out.println("Vui lòng chọn 1 hoặc 2");
               }
           } while (true);
       }catch (InputMismatchException|NumberFormatException e){
           System.out.println("Nhập không đúng yêu cầu.");
           loginOrRegister(scanner);
       }

    }


    // QUẢN LÝ NGỪƠI DÙNG
    private void displayUserMenu(Scanner scanner, User user) {
        try {
            boolean isLogin = true;
            do {
                System.out.println("********** USERS MENU**********");
                System.out.println("1. Trang chủ");
                System.out.println("2. Giỏ hàng");
                System.out.println("3. Thay đổi thông tin cá nhân");
                System.out.println("4. Đăng xuất");
                System.out.println("========================");
                System.out.println("Hãy đưa ra lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        isLogin = false;
                }
            } while (isLogin);
            loginOrRegister(scanner);
        }catch (InputMismatchException|NumberFormatException e){
            System.out.println("Nhập không đúng yêu cầu");
            displayUserMenu(scanner, user);
        }
    }


    // QUẢN LÝ ADMIN
    private void displayAdminMenu(Scanner scanner) {
        try {
            boolean isLogin = true;
            do {
                System.out.println("********** ADMIN MENU**********");
                System.out.println("1. Quản lý người dùng");
                System.out.println("2. Quản lý danh mục");
                System.out.println("3. Quản lý sản phẩm");
                System.out.println("4. Quản lý hoá đơn");
                System.out.println("5. Đăng xuất");
                System.out.println("==================================");
                System.out.println("Hãy đưa ra lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        userManagement(scanner);
                        break;
                    case 2:
                        CatagoryManagement(scanner);
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        isLogin = false;
                }
            } while (isLogin);
            loginOrRegister(scanner);
        }catch (InputMismatchException|NumberFormatException e){
            System.out.println("Nhập không đúng yêu cầu");
            displayAdminMenu(scanner);
        }

    }


    // Lấy thông tin đăng kí.
    private User registerUser(Scanner scanner) {
        User user = new User();
        System.out.println("Hãy nhập vào thông tin user:");
        System.out.println("Hãy chọn quyền tài khoản (1: ADMIN 2: USER)");
        user.setRole(validateRole());

        System.out.println("Hãy nhập vào họ tên đầy đủ");
        user.setFullName(validateFullName());

        System.out.println("Hãy nhập vào username");
        user.setUsername(validateUserName());

        System.out.println("Hãy nhập vào email");
        user.setEmail(validateEmail());

        System.out.println("Hãy nhập vào password");
        user.setPassword(validatePassword());

        System.out.println("Hãy nhập vào địa chỉ");
        user.setAddress(validateAdress());

        System.out.println("Hãy nhập vào số điện thoại");
        user.setPhone(validatePhone());

        user.setStatus(ACTIVE);
        user.setId(userLoginRegister.autoInc());

        System.out.println("Đăng kí thành công");
        return user;
    }

}
