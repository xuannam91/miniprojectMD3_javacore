package service;

import model.Product;
import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static constant.Constant.Atc.OFF;
import static constant.Constant.Atc.ON;
import static constant.Constant.ProductStatus.CON_HANG;
import static constant.Constant.Status.ACTIVE;
import static service.UserService.listedUsers;
import static service.UserService.userFileService;
import static validate.Validate.*;
import static validate.Validate.validatePhone;
import static validate.ValidateProduct.*;

public class InforUserService {

    // Đổi mật khẩu người dùng.
    public static void changePassUser(Scanner scanner, User user) {
        System.out.println("Nhập mật khẩu cũ");
        String password = scanner.nextLine();
        if (user.getPassword().equals(password)) {
            System.out.println("Nhập mật khẩu mới");
            user.setPassword(validatePassword());
            userFileService.saveToFile(user);
            System.out.println("Đổi mật khẩu thành công");
        } else {
            System.out.println("Mật khẩu cũ không chính xác");
        }
    }

    // Chỉnh sửa thông tin cá nhân
    public static void updateInforUser(Scanner scanner, User user){
        System.out.println("Nhập mật khẩu cũ");
        String password = scanner.nextLine();
        if(user.getPassword().equals(password)){

            System.out.println("Hãy nhập vào họ tên đầy đủ mới");
            user.setFullName(validateFullName());
            
            System.out.println("Hãy nhập vào địa chỉ mới");
            user.setAddress(validateAdress());

            System.out.println("Hãy nhập vào số điện thoại mới");
            user.setPhone(validatePhone());

            userFileService.saveToFile(user);
            System.out.println("Đã đổi thông tin sản phẩm thành công");
        }else {
            System.out.println("Mật khẩu cũ không chính xác");
        }
    }
}
