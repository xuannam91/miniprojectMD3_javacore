package service;

import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsersManagementService {

    // Quản lý trang chủ
    public static void homeManagement(Scanner scanner) {
        try {
            do {
                System.out.println("********** Home Management **********");
                System.out.println("1. Tìm kiếm sản phẩm còn hàng");
                System.out.println("2. Hiển thị 5 sản phẩm mới nhất");
                System.out.println("3. Hiển thị từng nhóm sản phẩm theo danh mục");
                System.out.println("4. Danh sách sản phẩm");
                System.out.println("5. Hiển thị danh sách sắp xếp theo giá tăng dần");
                System.out.println("6. Thêm vào giỏ hàng");
                System.out.println("7. Thoát khỏi trang chủ");
                System.out.println("Hãy đưa ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        // Tìm kiếm sản phẩm còn hàng theo tên
                        HomeService.searchProductInStock(scanner);
                        break;
                    case 2:
                        // Hiển thị sản phẩm nổi bật
                        HomeService.famous();
                        break;
                    case 3:
                        // Hiển thị từng nhóm sản phẩm theo danh mục
                        HomeService.searchProductByCategory(scanner);
                        break;
                    case 4:
                        // Danh sách sản phẩm
                        ProductService.displayProductList();

                        break;
                    case 5:
                        // Hiển thị danh sách sắp xếp theo giá tăng dần
                        HomeService.sortPriceUP();
                        break;
                    case 6:
                        // Thêm vào giỏ hàng

                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            homeManagement(scanner);
        }

    }

    // Giỏ hàng
    public static void CartManagement(Scanner scanner, User user) {
        try {
            do {
                System.out.println("********** Cart Management **********");
                System.out.println("1. Thay đổi số lượng đặt hàng");
                System.out.println("2. Xóa sản phẩm trong giỏ hàng");
                System.out.println("3. Đặt hàng");
                System.out.println("4. Hiển thị danh sách trong giỏ hàng");

                System.out.println("5. Thoát khỏi trang giỏ hàng");
                System.out.println("Hãy đưa ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        // Thay đổi số lượng đặt hàng

                        break;
                    case 2:
                        // Xóa sản phẩm trong giỏ hàng

                        break;
                    case 3:
                        // Đặt hàng
                        CartServive.addToCart(scanner, user);
                        break;
                    case 4:
                        // Hiển thị danh sách trong giỏ hàng
                        CartServive.displayListCart(user);
                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            CartManagement(scanner,user);
        }

    }

    //   Thông tin cá nhân.

    public static void inforUSerManagement(Scanner scanner, User user) {
        try {
            do {
                System.out.println("********** Home Management**********");
                System.out.println("1. Đổi mật khẩu");
                System.out.println("2. Hiển thị thông tin cá nhân");
                System.out.println("3. Chỉnh sửa thông tin cá nhân");
                System.out.println("4. Quay lại");
                System.out.println("Hãy đưa ra lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        // Đổi mật khẩu người dùng
                        InforUserService.changePassUser(scanner, user);
                        break;
                    case 2:
                        // Hiển thị thông tin cá nhân
                        System.out.println(user);
                        break;
                    case 3:
                        // Chỉnh sửa thông tin cá nhân
                        InforUserService.updateInforUser(scanner, user);
                        break;
                    default:
                        return;
                }
            } while (true);
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            homeManagement(scanner);
        }

    }

}
