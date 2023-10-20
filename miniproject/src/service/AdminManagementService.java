package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminManagementService {

    //Quản lý người dùng
    public static void userManagement(Scanner scanner) {
        try {
            do {
                System.out.println("**********User Management**********");
                System.out.println("1. Hiển thị danh sách người dùng");
                System.out.println("2. Tìm kiếm người dùng theo tên");
                System.out.println("3. Khoá/mở khoá người dùng");
                System.out.println("4. Thoát màn hình quản lý user");
                System.out.println("Hãy ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        // Hiển thị danh sách người dùng
                        UserService.displayUserList();
                        break;
                    case 2:
                        // Tìm kiếm người dùng theo tên
                        UserService.displayUserListByUsername(scanner);
                        break;
                    case 3:
                        // Khoá/mở khoá người dùng
                        UserService.changeUserStatus(scanner);
                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Nhập không đúng yêu cầu.");
            userManagement(scanner);
        }

    }


    // Quản lý danh mục
    public static void CatagoryManagement(Scanner scanner) {
        try {
            do {
                System.out.println("**********Category Management**********");
                System.out.println("1. Hiển thị danh sách danh mục");
                System.out.println("2. Tạo mới danh mục");
                System.out.println("3. Tìm kiếm danh mục theo tên");
                System.out.println("4. Chỉnh sửa thông tin danh mục");
                System.out.println("5. Xoá danh mục");
                System.out.println("6. Thoát màn hình quản lý danh mục");
                System.out.println("Hãy ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Nhập không đúng yêu cầu.");
            CatagoryManagement(scanner);
        }
    }
}
