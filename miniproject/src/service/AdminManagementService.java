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
                System.out.println("Hãy đưa ra lựa chọn của bạn");
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
            System.err.println("Nhập không đúng yêu cầu.");
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
                System.out.println("5. Ẩn danh mục theo mã danh mục ");
                System.out.println("6. Thoát màn hình quản lý danh mục");

                System.out.println("Hãy đưa ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        // Hiển thị danh sách danh mục.
                        CategoryService.displayCatalogList();
                        break;
                    case 2:
                        // Tạo mới một danh mục
                        CategoryService.saveCategory();
                        break;
                    case 3:
                        //Tìm kiếm danh mục theo tên
                        CategoryService.searchCategory(scanner);
                        break;
                    case 4:
                        // Chỉnh sửa thông tin danh mục.
                        CategoryService.updateCategoy(scanner);
                        break;
                    case 5:
                        // Ẩn danh mục theo mã danh mục.
                        CategoryService.changeCategoryStatus(scanner);
                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            CatagoryManagement(scanner);
        }
    }


    // Quản lý Sản phẩm
    public static void ProductManagement(Scanner scanner) {
        try {
            do {
                System.out.println("********** Product Management **********");
                System.out.println("1. Hiển thị danh sách sản phẩm");
                System.out.println("2. Thêm mới sản phẩm");
                System.out.println("3. Chỉnh sửa thông tin sản phẩm");
                System.out.println("4. Ẩn sản phẩm theo mã sản phẩm");
                System.out.println("5. Tìm kiếm sản phẩm theo tên ");
                System.out.println("6. Thoát màn hình quản lý sản phẩm");

                System.out.println("Hãy đưa ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        // Hiển thị danh sách sản phẩm.
                        ProductService.displayProductList();
                        break;
                    case 2:
                        // Thêm mới sản phẩm
                        ProductService.saveProduct();
                        break;
                    case 3:
                        //Chỉnh sửa thông tin sản phẩm.
                        ProductService.updateProduct(scanner);
                        break;
                    case 4:
                        // Ẩn sản phẩm theo mã sản phẩm.
                        ProductService.changeProductStatus(scanner);
                        break;
                    case 5:
                        // Tìm kiếm sản phẩm theo tên
                        ProductService.searchProduct(scanner);
                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            ProductManagement(scanner);
        }
    }
}
